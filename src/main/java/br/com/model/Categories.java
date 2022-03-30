package br.com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idCategories;
    private String categorieName;

    public Categories() {
    }

    public Categories(Long idCategories, String categorieName) {
        this.idCategories = idCategories;
        this.categorieName = categorieName;
    }

    public Long getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(Long idCategories) {
        this.idCategories = idCategories;
    }

    public String getCategorieName() {
        return categorieName;
    }

    public void setCategorieName(String categorieName) {
        this.categorieName = categorieName;
    }
}
