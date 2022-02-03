package com.points.taxcalculator.service.impl;

import com.points.taxcalculator.entity.TaxBracket;
import com.points.taxcalculator.entity.TaxBrackets;
import com.points.taxcalculator.exception.RemoteServerException;
import com.points.taxcalculator.service.TaxBracketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@CacheConfig(cacheNames = {"taxBrackets"})
public class TaxBracketServiceImpl implements TaxBracketService {

    @Value("${tax.brackets.url}")
    private String taxBracketsUrl;

    /**
     * gets the tax brackets from the remote api server by year
     *
     * @param year -
     * @return List<TaxBracket> -
     */
    @Cacheable(key = "#year", unless = "#result == null")
    @Override
    public List<TaxBracket> getTaxBrackets(int year) throws RemoteServerException {

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());

        try {
            TaxBrackets result = restTemplate.getForObject(taxBracketsUrl + "/" + year, TaxBrackets.class);
            log.info("rest connector response::::" + result);
            if (result != null) return result.getTaxBrackets();
            throw new RemoteServerException(String.format("Could not fetch tax bracket from server for year %s", year));
        } catch (Exception e) {
            log.error("Exception occurred during posting request " + e.getMessage());
            throw new RemoteServerException(String.format("Could not fetch tax bracket from server for year %s", year));
        }
    }


    /**
     * This is used to set read and socket timeout on the rest call
     *
     * @return ClientHttpRequestFactory
     * @see ClientHttpRequestFactory
     */
    private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(60000);
        factory.setConnectTimeout(60000);
        return factory;
    }
}
