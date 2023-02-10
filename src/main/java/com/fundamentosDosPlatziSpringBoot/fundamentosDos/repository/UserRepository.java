package com.fundamentosDosPlatziSpringBoot.fundamentosDos.repository;

import com.fundamentosDosPlatziSpringBoot.fundamentosDos.dto.UserDto;
import com.fundamentosDosPlatziSpringBoot.fundamentosDos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //ESTO ES UNA SONSULTA DESDE LA ANOTACIÓN QUERY
    @Query("Select u from User u WHERE u.email=?1 ")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);


    //ESTA ES UNA CONSULTA DENTRO DE UN METODO
    List<User> findByName(String name);

    //aquí estamos devolviendo un Optional
    Optional<User> findByEmailAndName(String email, String name);

    //CONSULTAS CON OTROS METODOS
    //LIKE, OR, AND, ORDERBY, BETWEN, SORT
    List<User> findByNameLike(String name);

    //Aquí estamos devolviendo una lista de usuarios
    List<User> findByNameOrEmail(String name, String email);

    //Aqupi también devolvemos una lista
    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);

    //vamos a devolver un Optional, creando una sentencia jpql
    //ASI CONSTRUIMOS NUESTRA QUERY CON JPQL CON NAMEDPARAMETRS
    @Query("SELECT new com.fundamentosDosPlatziSpringBoot.fundamentosDos.dto.UserDto(u.id, u.name, u.birthDate)" +
            "FROM User u " +
            "where u.birthDate=:parametroFecha " +
            "and u.email=:parametroEmail")
    //estos parametros los vamos a representar dentro del metodo con la anotación @Param
    //y colocamos la anotación y el parametro antes de la varibale
    Optional<UserDto>getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date,
                                                @Param("parametroEmail") String email);
}
