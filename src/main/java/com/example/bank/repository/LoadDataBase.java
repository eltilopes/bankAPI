package com.example.bank.repository;


import com.example.bank.entity.Agency;
import com.example.bank.entity.Bank;
import com.example.bank.entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AccountRepository contaRepository, BankRepository bancoRepository, AgencyRepository agenciaRepository) {
        Bank bancoBrasil = new Bank("001","Banco do Brasil");
        Bank bancoCEF = new Bank("104","Caixa Econômica Federal");

        Agency agenciaPenhorCEF = new Agency("Penhor","0154", 1,bancoCEF );
        Agency agenciaRuralBB = new Agency("Rural","0022", 4,bancoBrasil );

        Account contaBB = new Account("5555",5,1000.0, agenciaRuralBB);
        Account contaCEF = new Account("0104",9,10000.0, agenciaPenhorCEF);
        return args -> {
            log.info("Preloading Banco Brasil" + bancoRepository.save(bancoBrasil));
            log.info("Preloading CEF" + bancoRepository.save(bancoCEF));

            log.info("Preloading Agência Rural" + agenciaRepository.save(agenciaRuralBB));
            log.info("Preloading Agência Penhor" + agenciaRepository.save(agenciaPenhorCEF));

            log.info("Preloading Conta BB" + contaRepository.save(contaBB));
            log.info("Preloading Conta CEF" + contaRepository.save(contaCEF));
       };
    }
}