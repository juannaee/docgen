package com.example.docgen.mappers;

import com.example.docgen.dto.UserRequestDTO;
import com.example.docgen.dto.UserResponseDTO;
import com.example.docgen.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-16T17:58:22-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20250213-1140, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setName( dto.getName() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
        user.setBirthDate( dto.getBirthDate() );
        user.setPhone( dto.getPhone() );
        user.setCpf( dto.getCpf() );

        user.setRole( com.example.docgen.entities.enums.UserRole.USER );

        formatCpfAfterToEntity( user );

        return user;
    }

    @Override
    public UserResponseDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId( user.getId() );
        userResponseDTO.setName( user.getName() );
        userResponseDTO.setEmail( user.getEmail() );
        userResponseDTO.setPhone( user.getPhone() );
        if ( user.getRole() != null ) {
            userResponseDTO.setRole( user.getRole().name() );
        }

        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> toDtoList(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserResponseDTO> list = new ArrayList<UserResponseDTO>( user.size() );
        for ( User user1 : user ) {
            list.add( toDto( user1 ) );
        }

        return list;
    }
}
