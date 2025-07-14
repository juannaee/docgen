package com.example.docgen.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.docgen.entities.User;
import com.example.docgen.entities.enums.UserRole;

public class UserMapperDTO {

	// Converte uma requisição em entidade
	public static User toEntity(UserRequestDTO dto) {
		return new User(null, dto.getName(), dto.getEmail(), dto.getPassword(), dto.getBirthDate(), dto.getPhone(),
				dto.getCpf(), UserRole.USER);
	}

	// Converte uma entidade em um dto
	public static UserResponseDTO toDto(User user) {
		return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone(),
				user.getRole().getRoleName());
	}

	// Converte uma lista de usuarios em uma lista DTO
	public static List<UserResponseDTO> toDtoList(List<User> users) {
		return users.stream().map(UserMapperDTO::toDto).collect(Collectors.toList());
	}

}
