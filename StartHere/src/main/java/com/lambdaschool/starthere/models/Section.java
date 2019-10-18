package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
        import io.swagger.annotations.ApiModel;
        import io.swagger.annotations.ApiModelProperty;

        import javax.persistence.*;
        import java.util.ArrayList;
        import java.util.List;

@ApiModel(value = "Section",description = "The Section Entity")
@Entity
@Table(name = "section")
public class Section extends Auditable
{
    @ApiModelProperty(name = "sectionid", value="primary key for section id", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    @ApiModelProperty(name = "name", value="primary key for section name", required = true, example = "fiction")
    @Column(nullable = false,
            unique = true)
    private String name;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("section")
    private List<Book> books = new ArrayList<>();

    public Section() {
    }

    public Section(String name, List<Book> books) {
        this.name = name;
        this.books = new ArrayList<>();
        this.books = books;
    }

    public long getSectionid() {
        return sectionid;
    }

    public void setSectionid(long sectionid) {
        this.sectionid = sectionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionid=" + sectionid +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
