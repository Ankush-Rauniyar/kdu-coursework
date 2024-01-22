package config;

import beans.Tyre;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TyreService {
    @Bean(name = "mrf")
     Tyre tyre1(){
        Tyre tyre = new Tyre();
        tyre.setBrand("MRF");
        tyre.setPrice(1500);
        return tyre;
    }

    @Bean(name = "bridgestone")
    Tyre tyre2(){
        Tyre tyre = new Tyre();
        tyre.setBrand("BridgeStone");
        tyre.setPrice(2000);
        return tyre;
    }
}
