package io.github.jacksonhua;

import io.github.jacksonhua.api.UsersApi;
import io.github.jacksonhua.dto.DemoUserDTO;
import io.github.jacksonhua.dto.UserCreateCommand;
import io.github.jacksonhua.dto.UserUpdateCommand;
import io.github.jacksonhua.common.web.response.Page;
import io.github.jacksonhua.common.web.response.Result;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


/**
 * @author whh
 */

//@ConditionalOnProperty(prefix = "openapi", name = "enabled", havingValue = "true")
@RestController("demo")
@Conditional(ShowDemoCondition.class)
public class DemoController implements UsersApi {


    @Override
    public Result<DemoUserDTO> createUser(UserCreateCommand userCreateCommand) {
        return null;
    }

    @Override
    public Result<Void> deleteUser(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Resource> exportUserInfo(UUID id) {
        Resource resource = new FileSystemResource("path/to/file.pdf");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"file.pdf\"")
                .body(resource);
    }

    @Override
    public Result<DemoUserDTO> getUserById(UUID id) {
        return null;
    }

    @Override
    public Result<Page<DemoUserDTO>> getUsersById(Integer page, Integer size) {
        return null;
    }

    @Override
    public Result<DemoUserDTO> updateUser(UUID id, UserUpdateCommand userUpdateCommand) {
        return null;
    }

    @Override
    public Result<Void> uploadUserAvatar(UUID id, MultipartFile file, String description) {
        return null;
    }

}
