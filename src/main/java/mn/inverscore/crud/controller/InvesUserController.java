package mn.inverscore.crud.controller;

import mn.inverscore.crud.dto.InvesUserDto;
import mn.inverscore.crud.entity.InvesUserEntity;
import mn.inverscore.crud.repository.InvesUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class InvesUserController {

    @Autowired
    private InvesUserRepository invesUserRepository;

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody InvesUserDto userDto) {
        try {
            InvesUserEntity entity = new InvesUserEntity();
            entity.setName(userDto.getName());
            entity.setPhone(userDto.getPhone());
            entity.setEmail(userDto.getEmail());
            InvesUserEntity saveEntity = invesUserRepository.save(entity);
            invesUserRepository.flush();
            return ResponseEntity.ok().body(String.valueOf(saveEntity.getId()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<InvesUserDto> getUser(@PathVariable String id) {
        try {
            long userId = Long.parseLong(id);
            Optional<InvesUserEntity> userEntity = invesUserRepository.findById(userId);
            if(userEntity.isPresent()) {
                InvesUserEntity entity = userEntity.get();
                InvesUserDto userDto = new InvesUserDto();
                userDto.setId(entity.getId());
                userDto.setEmail(entity.getEmail());
                userDto.setPhone(entity.getPhone());
                userDto.setName(entity.getName());
                return ResponseEntity.ok().body(userDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            return  ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/updateUser")
    public ResponseEntity<String> updateUser() {
        return  null;
    }

    @GetMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        return  null;
    }

}
