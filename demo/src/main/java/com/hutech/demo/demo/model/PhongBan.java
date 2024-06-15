package com.hutech.demo.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
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
