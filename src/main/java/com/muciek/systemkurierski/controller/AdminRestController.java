/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.Location;
import com.muciek.systemkurierski.models.PackageOption;
import com.muciek.systemkurierski.models.PackageStatus;
import com.muciek.systemkurierski.models.Shipment;
import com.muciek.systemkurierski.models.User;
import com.muciek.systemkurierski.service.CourierService;
import com.muciek.systemkurierski.service.LocationService;
import com.muciek.systemkurierski.service.PackageOptionService;
import com.muciek.systemkurierski.service.PackageStatusService;
import com.muciek.systemkurierski.service.ShipmentService;
import com.muciek.systemkurierski.service.UserInfoService;
import com.muciek.systemkurierski.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Muman
 */
@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    CourierService courierService;

    @Autowired
    LocationService locationService;

    @Autowired
    PackageOptionService packageOptionService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    UserService userService;

    @Autowired
    ShipmentService shipmentService;

    @Autowired
    PackageStatusService packageStatusService;

    public ShipmentService getShipmentService() {
        return shipmentService;
    }

    public void setShipmentService(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    public PackageStatusService getPackageStatusService() {
        return packageStatusService;
    }

    public void setPackageStatusService(PackageStatusService packageStatusService) {
        this.packageStatusService = packageStatusService;
    }

    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CourierService getCourierService() {
        return courierService;
    }

    public void setCourierService(CourierService courierService) {
        this.courierService = courierService;
    }

    public LocationService getLocationService() {
        return locationService;
    }

    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    public PackageOptionService getPackageOptionService() {
        return packageOptionService;
    }

    public void setPackageOptionService(PackageOptionService packageOptionService) {
        this.packageOptionService = packageOptionService;
    }

    /**
     * Couriers *
     */
    @RequestMapping(value = "/courier", method = RequestMethod.GET)
    public @ResponseBody
    List<Courier> getAllCouriers() {
        return courierService.getAllCouriers();
    }

    @RequestMapping(value = "/courier/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Courier getCourierById(@PathVariable("id") String id) {
        Courier requestedCourier = getCourierService().getCourierById(Integer.valueOf(id));
        return requestedCourier;
    }

    @RequestMapping(value = "/courier", method = RequestMethod.POST)
    public @ResponseBody
    void addCourier(@RequestBody Courier newCourier) {
        getCourierService().addCourier(newCourier);
    }

    @RequestMapping(value = "/courier/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteCourier(@PathVariable("id") String id) {
        Courier courierToDelete = getCourierService().getCourierById(Integer.valueOf(id));
        getCourierService().deleteCourier(courierToDelete);
    }

    @RequestMapping(value = "/courier", method = RequestMethod.PUT)
    public @ResponseBody
    void updateCourier(@RequestBody Courier courierToUpdate) {
        getCourierService().updateCourier(courierToUpdate);
    }

    /**
     * Locations *
     */
    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public @ResponseBody
    List<Location> getAllLocations() {
        List<Location> allLocationsList = getLocationService().getAllLocations();
        return allLocationsList;
    }

    @RequestMapping(value = "/location", method = RequestMethod.POST)
    public @ResponseBody
    void addNewLocation(@RequestBody Location newLocation) {

        System.out.print(newLocation.getAddress());

        getLocationService().addLocation(newLocation);
    }

    @RequestMapping(value = "/location", method = RequestMethod.PUT)
    public @ResponseBody
    void updateLocation(@RequestBody Location locationToUpdate) {
        System.out.print(locationToUpdate.getAddress());
        getLocationService().updateLocation(locationToUpdate);
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Location getLocation(@PathVariable("id") String id) {
        return getLocationService().getLocationById(Integer.valueOf(id));
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteLocation(@PathVariable("id") String id) {
        Location locationToDelete = getLocationService().getLocationById(Integer.parseInt(id));
        getLocationService().deleteLocation(locationToDelete);
    }

    /**
     * PackageOption *
     */
    @RequestMapping(value = "/packageOption", method = RequestMethod.GET)
    public @ResponseBody
    List<PackageOption> getAllPackageOptions() {
        return getPackageOptionService().getAllPackageOptions();
    }

    @RequestMapping(value = "/packageOption", method = RequestMethod.POST)
    public @ResponseBody
    void addPackageOption(@RequestBody PackageOption newPackageOption) {
        getPackageOptionService().addPackageOption(newPackageOption);
    }

    @RequestMapping(value = "/packageOption/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deletePackageOption(@PathVariable("id") String id) {
        PackageOption packageOption = getPackageOptionService().getPackageOptionById(Integer.valueOf(id));
        getPackageOptionService().deletePackageOption(packageOption);
    }

    @RequestMapping(value = "/packageOption", method = RequestMethod.PUT)
    public @ResponseBody
    void updatePackageOption(@RequestBody PackageOption packageOption) {
        getPackageOptionService().updatePackageOption(packageOption);
    }

    @RequestMapping(value = "/packageOption/{id}")
    public @ResponseBody
    PackageOption getPackageOptionById(@PathVariable("id") String id) {
        PackageOption packageOption = getPackageOptionService().getPackageOptionById(Integer.valueOf(id));
        return packageOption;
    }

    /**
     * Users *
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAllUsers() {
        return getUserService().getAllUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody
    void addUser(@RequestBody User newUser) {
        getUserService().addUser(newUser);
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteUser(@PathVariable("username") String name) {
        User user = getUserService().getUserByName(name);
        getUserService().deleteUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public @ResponseBody
    void updateUser(@RequestBody User user) {
        getUserService().updateUser(user);
    }

    @RequestMapping(value = "/user/{username}")
    public @ResponseBody
    User getUserByName(@PathVariable("username") String name) {
        User user = getUserService().getUserByName(name);
        return user;
    }

    @RequestMapping(value = "/package/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Shipment getPackage(@PathVariable("id") String id) {
        Shipment shipment = getShipmentService().getById(Integer.valueOf(id));
        return shipment;
    }

    @RequestMapping(value = "/package", method = RequestMethod.GET)
    public @ResponseBody
    List<Shipment> getUserPackages() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Shipment> userPackages = getShipmentService().getAllPackagesForUser(userName);
        return userPackages;
    }

    @RequestMapping(value = "/package/{id}/packageStatus", method = RequestMethod.GET)
    public @ResponseBody
    List<PackageStatus> getPackageStatusesForPAckageWithId(@PathVariable("id") String id) {
        List<PackageStatus> packageStatuses = getPackageStatusService().getAllWithPackageId(Integer.valueOf(id));
        return packageStatuses;
    }
}
