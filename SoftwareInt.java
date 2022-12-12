package com.example.Software.SoftwareInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Software.Model.Software;

public interface SoftwareInt extends JpaRepository<Software,Integer> {

}
