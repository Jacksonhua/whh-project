package io.github.jacksonhua;
import io.github.jacksonhua.api.UsersApi;
import io.github.jacksonhua.dto.UserCreateDTO;
import io.github.jacksonhua.dto.UserDTO;
import io.github.jacksonhua.dto.UserUpdateDTO;
import io.github.jacksonhua.web.response.Page;
import io.github.jacksonhua.web.response.Result;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController("demo")
public class DemoController implements UsersApi {


    @Override
    public Result<UserDTO> createUser(UserCreateDTO userCreateDTO) {
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
    public Result<UserDTO> getUserById(UUID id) {
        return null;
    }

    @Override
    public Result<Page<UserDTO>> getUsersById(Integer page, Integer size) {
        return null;
    }

    @Override
    public Result<UserDTO> updateUser(UUID id, UserUpdateDTO userUpdateDTO) {
        return null;
    }

    @Override
    public Result<Void> uploadUserAvatar(UUID id, MultipartFile file, String description) {
        return Result.success();
    }
}
