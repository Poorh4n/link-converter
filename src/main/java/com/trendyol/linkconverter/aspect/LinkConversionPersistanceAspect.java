package com.trendyol.linkconverter.aspect;

import com.trendyol.linkconverter.data.repository.LinkConversionRepo;
import com.trendyol.linkconverter.mapper.LinkMapper;
import com.trendyol.linkconverter.model.request.DeepLinkConversionRequest;
import com.trendyol.linkconverter.model.request.LinkConversionRequest;
import com.trendyol.linkconverter.model.request.WebLinkConversionRequest;
import com.trendyol.linkconverter.model.response.LinkConversionResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LinkConversionPersistanceAspect {

    @Autowired
    LinkConversionRepo linkConversionRepo;

    @Autowired
    LinkMapper linkMapper;

    @Around("@annotation(com.trendyol.linkconverter.annotations.Persist)")
    public void persistConversionRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Object retval = joinPoint.proceed();
        String convertedLink = ((LinkConversionResponse)retval).getConvertedLink();
        for(Object arg : args) {
            if( arg instanceof WebLinkConversionRequest) {
                String link = ((WebLinkConversionRequest)arg).getLink();
                saveRequest(convertedLink, link);
            }
            if( arg instanceof DeepLinkConversionRequest) {
                String link = ((DeepLinkConversionRequest)arg).getLink();
                saveRequest(convertedLink, link);
            }
        }

    }

    private void saveRequest(String convertedLink, String link) {
        if (linkConversionRepo.findFirstBySource(link).isPresent() == false)
            linkConversionRepo.save(linkMapper.toEntity(new LinkConversionRequest(link, convertedLink)));
    }
}
