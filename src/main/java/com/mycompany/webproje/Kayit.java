/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webproje;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author Fatih Dursun Uzer
 */
@ManagedBean
@RequestScoped
@Entity
@Table(name="ogrenci")
public class Kayit {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="yas")
    private int yas;
    @Column(name="email")
    private String email;
    @Column(name="sifre")
    private int sifre;
    
    public void setName(String name)
    {
        this.name=name;
    }
    public void setSurname(String surname)
    {
        this.surname=surname;
    }
    
    public String getName()
    {
        return name;
    }
    public String getSurname()
    {
        return surname;
    }
    public void save()
    {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Kayit.class).buildSessionFactory();
        Session x=factory.getCurrentSession();
        try{
        x.beginTransaction();
        x.save(this);
        x.getTransaction().commit();
        }
        catch(Exception e){
            e.getStackTrace();
            x.close();
    }
        System.out.println("Saved");
    }
    public void setyas(int yas)
    {
        this.yas=yas;
    }
    public int getyas()
    {
        return yas;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    
    public int getSifre()
    {
        return sifre;
    }
    public void setSifre(int sifre)
    {
        this.sifre=sifre;
    }
}
