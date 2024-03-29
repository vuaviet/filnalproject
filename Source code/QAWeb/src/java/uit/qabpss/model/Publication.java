package uit.qabpss.model;

import java.util.Date;
import java.util.List;

public class Publication implements Comparable {

    @Override
    public String toString() {
        return title;
    }
    public String toHtmlStr()
    {
        String htmlTitle = "<a href='./showPubDetail.do?id=" + getId() + "' style=\"font-size: 16px;line-height: 22px;\">" + getTitle() + "</a>";
        String br = "<br>";
        String htmlAuthor = "Author: " + authors;
        String htmlYear = " - " + getYear();
        String htmlSource = "Source: " + source;
        return htmlTitle + br + htmlAuthor + htmlYear + br + htmlSource;
    }
    public String getCrossref() {
        return crossref;
    }

    public void setCrossref(String crossref) {
        this.crossref = crossref;
    }

    public String getDblp_key() {
        return dblp_key;
    }

    public void setDblp_key(String dblp_key) {
        this.dblp_key = dblp_key;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getEe() {
        return ee;
    }

    public void setEe(String ee) {
        this.ee = ee;
    }

    public String getEe_PDF() {
        return ee_PDF;
    }

    public void setEe_PDF(String ee_PDF) {
        this.ee_PDF = ee_PDF;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getTitleSignature() {
        return titleSignature;
    }

    public void setTitleSignature(String titleSignature) {
        this.titleSignature = titleSignature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Publication> getRefPubs() {
        return refPubs;
    }

    public void setRefPubs(List<Publication> refPubs) {
        this.refPubs = refPubs;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    private int id;
    private String dblp_key;
    private String title;
    private String source;
    private String source_id;
    private String series;
    private int year;
    private String type;
    private String volume;
    private String number;
    private String month;
    private String pages;
    private String ee;
    private String ee_PDF;
    private String url;
    private String publisher;
    private String isbn;
    private String crossref;
    private String titleSignature;
    private String doi;
    private Date mdate;
    private List<Publication> refPubs;
    private List<Author> authors;

    @Override
    public int compareTo(Object o) {
        Publication temp = (Publication) o;
        if (temp.year > this.year) {
            return 1;
        } else if (temp.year < this.year) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if(obj.getClass() == String.class)
        {
            if(title.equalsIgnoreCase(obj.toString()))
                return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publication other = (Publication) obj;
        if ((this.dblp_key == null) ? (other.dblp_key != null) : !this.dblp_key.equals(other.dblp_key)) {
            return false;
        }
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
}
