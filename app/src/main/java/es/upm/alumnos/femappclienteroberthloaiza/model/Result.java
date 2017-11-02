package es.upm.alumnos.femappclienteroberthloaiza.model;

import java.io.Serializable;

/**
 * Created by Usuario on 29/10/2017.
 */

public class Result implements Serializable {

    private Integer id;
    private String name;
    private String tags;
    private Integer price_in_cents;
    private String primary_category;
    private String origin;
    private Integer package_unit_volume_in_milliliters;
    private Integer alcohol_content;
    private String producer_name;
    private String image_thumb_url;
    private String varietal;
    private String style;

    public Result(Integer id, String name, String tags, Integer price_in_cents, String primary_category,
                  String origin, Integer package_unit_volume_in_milliliters, Integer alcohol_content,
                  String producer_name, String image_thumb_url, String varietal, String style) {
        this.setId(id);
        this.setName(name);
        this.setTags(tags);
        this.setPrice_in_cents(price_in_cents);
        this.setPrimary_category(primary_category);
        this.setOrigin(origin);
        this.setPackage_unit_volume_in_milliliters(package_unit_volume_in_milliliters);
        this.setAlcohol_content(alcohol_content);
        this.setProducer_name(producer_name);
        this.setImage_thumb_url(image_thumb_url);
        this.setVarietal(varietal);
        this.setStyle(style);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getPrice_in_cents() {
        return price_in_cents;
    }

    public void setPrice_in_cents(Integer price_in_cents) {
        this.price_in_cents = price_in_cents;
    }

    public String getPrimary_category() {
        return primary_category;
    }

    public void setPrimary_category(String primary_category) {
        this.primary_category = primary_category;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getPackage_unit_volume_in_milliliters() {
        return package_unit_volume_in_milliliters;
    }

    public void setPackage_unit_volume_in_milliliters(Integer package_unit_volume_in_milliliters) {
        this.package_unit_volume_in_milliliters = package_unit_volume_in_milliliters;
    }

    public Integer getAlcohol_content() {
        return alcohol_content;
    }

    public void setAlcohol_content(Integer alcohol_content) {
        this.alcohol_content = alcohol_content;
    }

    public String getProducer_name() {
        return producer_name;
    }

    public void setProducer_name(String producer_name) {
        this.producer_name = producer_name;
    }

    public String getImage_thumb_url() {
        return image_thumb_url;
    }

    public void setImage_thumb_url(String image_thumb_url) {
        this.image_thumb_url = image_thumb_url;
    }

    public String getVarietal() {
        return varietal;
    }

    public void setVarietal(String varietal) {
        this.varietal = varietal;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }


}
