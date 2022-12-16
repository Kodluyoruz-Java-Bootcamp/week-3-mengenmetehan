package com.emlakcepte.controller;


import com.emlakcepte.model.Realty;
import com.emlakcepte.service.RealtyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/realty")
public class RealtyController {

    private final RealtyService m_realtyService;

    public RealtyController(RealtyService realtyService)
    {
        m_realtyService = realtyService;
    }

    @GetMapping("/all")
    public List<Realty> getAllRealty()
    {
        return m_realtyService.getAll();
    }

    @PostMapping
    public ResponseEntity<Realty> createRealty(Realty realty)
    {
        if(m_realtyService.createRealty(realty))
            return new ResponseEntity<>(realty, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(realty, HttpStatus.BAD_REQUEST);
    }

    // http://localhost:8080/api/realty/provincedistrict?p="Izmır"&y="Narlidere"
    @GetMapping("/provincedistrict")
    public List<Realty> findByProvinceAndDistrict (@RequestParam("p") String province, @RequestParam("y") String district)
    {
        return m_realtyService.getAllByProvinceAndDistrict(province, district);
    }

    @GetMapping("showcase")
    public List<Realty> getShowcaseOfProvince(@RequestParam("p") String province)
    {
        return switch (province) {
            case "Istanbul" -> m_realtyService.getAllAtIstanbulProvince();
            case "Ankara" -> m_realtyService.getAllAtAnkaraProvince();
            case "Izmir" -> m_realtyService.getAllAtIzmirProvince();
            default -> throw new IllegalArgumentException();
        };
    }

    @GetMapping("advert_count")
    public long getAdvertCountOfProvince(@RequestParam("p") String province)
    {
        return switch (province) {
            case "Istanbul" -> m_realtyService.countOfIstanbulProvince();
            case "Ankara" -> m_realtyService.countOfAnkaraProvince();
            case "Izmir" -> m_realtyService.countOfIzmirProvince();
            default -> throw new IllegalArgumentException();
        };
    }

    // http://localhost:8080/api/realty/sales_count?p=Ankara
    @GetMapping("sales_count")
    public long getSalesCountOfProvince(@RequestParam("p") String province)
    {
        return switch (province) {
            case "Istanbul" -> m_realtyService.countOfSalesIstanbulProvince();
            case "Ankara" -> m_realtyService.countOfSalesAnkaraProvince();
            case "Izmir" -> m_realtyService.countOfSalesIzmirProvince();
            default -> throw new IllegalArgumentException();
        };
    }


}
