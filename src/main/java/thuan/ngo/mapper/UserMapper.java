package thuan.ngo.mapper;

import java.util.Base64;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import thuan.ngo.dao.User;
import thuan.ngo.user.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	@Named("hashPassword")
	public static String hashPassword(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}
	
	@Mapping(source = "password", target = "password", qualifiedByName = "hashPassword")
	public User toEntity(UserModel userModel);
	
	public UserModel toModel(User userEntity);
}
