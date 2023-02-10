package com.fundamentosDosPlatziSpringBoot.fundamentosDos;

import com.fundamentosDosPlatziSpringBoot.fundamentosDos.bean.MyBean;
import com.fundamentosDosPlatziSpringBoot.fundamentosDos.bean.MyBeanWithDependency;
import com.fundamentosDosPlatziSpringBoot.fundamentosDos.bean.MyBeanWithPrperties;
import com.fundamentosDosPlatziSpringBoot.fundamentosDos.component.ComponentDependency;
import com.fundamentosDosPlatziSpringBoot.fundamentosDos.entity.User;
import com.fundamentosDosPlatziSpringBoot.fundamentosDos.pojo.UserPojo;
import com.fundamentosDosPlatziSpringBoot.fundamentosDos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class FundamentosDosApplication implements CommandLineRunner {
    private final Log LOGGER = LogFactory.getLog(FundamentosDosApplication.class);

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MyBeanWithPrperties myBeanWithPrperties;
    private UserPojo userPojo;
    private UserRepository userRepository;

    public FundamentosDosApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithPrperties myBeanWithPrperties, UserPojo userPojo, UserRepository userRepository) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myBeanWithPrperties = myBeanWithPrperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosDosApplication.class, args);
    }

    @Override
    public void run(String... args) {
        //ejemplosAnteriores();
        saveUsersInDataBase();
        getInformationJpqlFromUser();
    }

    private void getInformationJpqlFromUser() {
        LOGGER.info("Usuario con el metodo findByUserEmail" +
                userRepository.findByUserEmail("Ericka@domain.com")
                        .orElseThrow(() -> new RuntimeException("no se encontro el usuario")));

        System.out.println("+++++CONSULTANDO CON EL METODO findAndSort, le paso como parametro el nombre y el me ordenara++++");
        userRepository.findAndSort("user", Sort.by("id").descending())
                .stream()
                .forEach(user -> LOGGER.info("Usuario con el metodo Sort " + user));

        System.out.println("CONSULTANDO CON EL METODO findbyName, CONSULTA SIN LA ANOTACIÓN QUERY");
        userRepository.findByName("Flo")
                .stream()

                .forEach(user -> LOGGER.info("Usuario con query metodo ++++++++" + user));

        LOGGER.info(
                "usurio con query metodo email mas name" +
                        userRepository.findByEmailAndName
                                        ("Andeina@domain.com", "user1")
                                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        System.out.println("+++++++++++++++++++++++++++++FINAL++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++CONSULTANDO CON EL METODO findByNameLike++++++++++++++++++++++++++");
        //buscaremos a todos los usuarios que comiencen con u
        userRepository.findByNameLike("%u%")
                //con stream nos traemos a todos los usuarios
                .stream()
                .forEach(user -> LOGGER.info("USUARIO ENCONTRADO CON EL MEETODO findByNameLike " + user))

        ;
        System.out.println("+++++++++++++++++++++++++++++FINAL++++++++++++++++++++++++++");


        System.out.println("+++++++++++++++++++++++++++++CONSULTANDO CON EL METODO findByNameOrEmail++++++++++++++++++++++++++");

        userRepository.findByNameOrEmail(null, "Ericka@domain.com")

                .stream()
                .forEach(user -> LOGGER.info("este usuario fue encontrado con el metodo findByNameOrEmail" + user));
        //.orElseThrow(() -> new RuntimeException("Usuario no encontrado por nombre ni email"));

        System.out.println("+++++++++++++++++++++++++++++FINAL++++++++++++++++++++++++++");

        System.out.println("+++++++++++++++++++++++++++++CONSULTANDO con intervalo de fechas++++++++++++++++++++++++++");
        userRepository
                .findByBirthDateBetween(LocalDate.of(2023, 3, 1), LocalDate.of(2023, 8, 1))
                .stream()
                .forEach(user -> LOGGER.info("Usuario encontrado con el intervalo de fechas" + user));
        System.out.println("+++++++++++++++++++++++++++++FINAL++++++++++++++++++++++++++");

        System.out.println("+++++++++++++++++++++++++++++CONSULTANDO con like y ordenado de forma descendente++++++++++++++++++++++++++");
        userRepository.findByNameLikeOrderByIdDesc("%user%")
                .stream()
                .forEach(user -> LOGGER.info("usuario encontrado con like y ordenado" + user));
        System.out.println("+++++++++++++++++++++++++++++FINAL++++++++++++++++++++++++++");

        System.out.println("+++++++++++++++++++++++++++++CONSULTANDO con getAllByBirthDateAndEmail++++++++++++++++++++++++++");
        LOGGER.info("el usuario con named paramter es:" + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2023, 03, 27),
                        "Santiago@domain.com")
        .orElseThrow(() ->
                new RuntimeException("no se encontro apartir del named parameter")));
    }

    private void saveUsersInDataBase() {
        User user1 = new User("Ericka", "Ericka@domain.com", LocalDate.of(2023, 01, 27));
        User user2 = new User("user1", "Andeina@domain.com", LocalDate.of(2023, 02, 27));
        User user3 = new User("user2", "Santiago@domain.com", LocalDate.of(2023, 03, 27));
        User user4 = new User("user3", "Josue@domain.com", LocalDate.of(2023, 04, 27));
        User user5 = new User("user4", "Clemente@domain.com", LocalDate.of(2023, 05, 27));
        User user6 = new User("Anastasia", "Anastasia@domain.com", LocalDate.of(2023, 06, 27));
        User user7 = new User("Flo", "Flo@domain.com", LocalDate.of(2023, 07, 27));
        User user8 = new User("Pedro", "Pedro@domain.com", LocalDate.of(2023, 8, 27));
        User user9 = new User("Juan", "Juan@domain.com", LocalDate.of(2023, 9, 27));
        User user10 = new User("Diego", "Diego@domain.com", LocalDate.of(2023, 10, 27));
        User user11 = new User("Alejandro", "Alejandro@domain.com", LocalDate.of(2023, 11, 27));
        User user12 = new User("Maria", "Maria@domain.com", LocalDate.of(2023, 12, 27));
        List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
        list.stream().forEach(userRepository::save);

    }

    private void ejemplosAnteriores() {
        componentDependency.saludar();
        myBean.print();
        myBeanWithDependency.printWithDepedency();
        System.out.println(myBeanWithPrperties.function());
        System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword() + "-" + userPojo.getAge());
        try {
            int value = 10 / 0;
            LOGGER.debug("FUNCIONO SE DIVIDIO DIEZ ENTRE CERO");
        } catch (Exception e) {
            LOGGER.error("NO SE PUEDE DIVIDIR DIEZ ENTRE CERO" + e.getMessage());
        }

    }
}
