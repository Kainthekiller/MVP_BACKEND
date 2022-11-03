package PMCS_MVP.PMCS_MVP.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class PMCS {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    String itemName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate publishDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String tmNumber;



    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer pageCount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer pagePmcsStart;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String link;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String imgLink;


//Getter and Setters
public String getImgLink() {
    return imgLink;
}

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }




    public String getTmNumber() {
        return tmNumber;
    }

    public void setTmNumber(String tmNumber) {
        this.tmNumber = tmNumber;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPagePmcsStart() {
        return pagePmcsStart;
    }

    public void setPagePmcsStart(Integer pagePmcsStart) {
        this.pagePmcsStart = pagePmcsStart;
    }
}
