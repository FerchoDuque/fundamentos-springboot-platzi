package com.fundamentos.platzi.springboot.Fundamentos.entities;

import jakarta.persistence.*;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable=false, unique = true)
    private Long id;

    @Column(name="descripcion", length = 255)
    private String descripcion;

    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(String descripcion, User user) {
        this.descripcion = descripcion;
        this.user = user;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", user=" + user +
                '}';
    }
}
