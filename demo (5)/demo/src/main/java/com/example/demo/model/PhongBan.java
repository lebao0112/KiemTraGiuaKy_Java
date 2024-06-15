package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phongban")
public class PhongBan {
    @Id
    @Column(name = "maphongban", length = 2)
    private String phongbanId;

    @Column(name = "tenphongban", length = 30)
    @NotBlank(message="Ten phong ban khong duoc de trong")
    private String name;
}
