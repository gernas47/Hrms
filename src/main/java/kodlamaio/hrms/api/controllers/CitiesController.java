package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cities/")
public class CitiesController {

    CityService cityService;

    @Autowired
    public CitiesController(CityService cityService){
        this.cityService = cityService;
    }

    @PostMapping("add")
    public Result add(City city){
        return this.cityService.add(city);
    }

    @GetMapping("getall")
    public DataResult<List<City>> getall(){
        return this.cityService.getall();
    }

    @GetMapping("getById")
    public DataResult<City> getById(@RequestParam int id){
        return this.cityService.getById(id);
    }
}
