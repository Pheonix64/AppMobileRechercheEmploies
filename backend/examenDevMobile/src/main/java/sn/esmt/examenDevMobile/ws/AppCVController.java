package sn.esmt.examenDevMobile.ws;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.esmt.examenDevMobile.dao.AppCVRepository;
import sn.esmt.examenDevMobile.entities.AppCVEntity;
import java.util.List;

@RestController
@RequestMapping(value = "userscv")
@AllArgsConstructor

public class AppCVController {
    private AppCVRepository appCVRepository;
    @PostMapping(path = "/save")
    public AppCVEntity save(@RequestBody AppCVEntity appCVEntity){
        return appCVRepository.save(appCVEntity);
    }
    @GetMapping(path = "/all")
    public List<AppCVEntity> getAll(){
        return appCVRepository.findAll();
    }

}