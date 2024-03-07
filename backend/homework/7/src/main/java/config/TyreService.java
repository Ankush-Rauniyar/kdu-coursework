package config;

import entities.Tyre;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TyreService {
    /**
     *
     * @return Tyre
     */
    @Bean(name = "mrf")
     Tyre tyre1(){
        Tyre tyre = new Tyre();
        tyre.setBrand("MRF");
        tyre.setPrice(1500);
        return tyre;
    }

    /**
     *
     * @return Tyre
     */
    @Bean(name = "bridgestone")
    Tyre tyre2(){
        Tyre tyre = new Tyre();
        tyre.setBrand("BridgeStone");
        tyre.setPrice(2000);
        return tyre;
    }
}
