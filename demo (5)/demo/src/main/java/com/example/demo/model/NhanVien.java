package com.example.demo.model;

import jakarta.persistence.*;
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
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @Column(name="manv", length = 3)
    private String id;

    @Column(name = "tennv", length = 100)
    @NotBlank(message = "Ten nhan vien khong duoc de trong")
    private String tenNv;

    @Column(name = "phai", length = 3)
    private String phai;

    @Column(name = "noisinh", length = 200)
    private String noiSinh;
    private int luong;
    @ManyToOne
    @JoinColumn(name = "phongbanId")
    private PhongBan phongBan;


}
