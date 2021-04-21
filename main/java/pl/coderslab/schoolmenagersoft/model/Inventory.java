package pl.coderslab.schoolmenagersoft.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "inventoiries")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "inventory_name")
    @NotBlank
    @Size(min = 2, max = 30)
    private String inventoryType;
    @Column(name = "inventory_number")
    @NotNull
    private int merchandiseNumber;
    @Column(name = "quantity")
    @NotNull
    private double quantity;
    @Column(name = "invoice_number")
    @NotBlank
    private String invoiceNumber;
    @Column(name = "purchase_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate purchaseDate;
    @NotNull
    private BigDecimal price;
    @Column(name = "assigment_person")
    @NotBlank
    @Size(min = 2, max = 30)
    private String assigmentToPerson;
    @Column(name = "liquidation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate merchandiseLiquidationDate;
    @Column(name = "liquidation_method")
    @NotBlank
    @Size(min = 2, max = 30)
    private String methodOfGoodsDisposal;
    @Column(name = "responsible_for_liquidation")
    @NotBlank
    @Size(min = 2, max = 30)
    private String personResponsibleForLiquidation;

    public Inventory() {
    }

    public Inventory(String inventoryType, int merchandiseNumber,
                     double quantity, String invoiceNumber, LocalDate purchaseDate,
                     BigDecimal price, String assigmentToPerson, LocalDate merchandiseLiquidationDate,
                     String methodOfGoodsDisposal, String personResponsibleForLiquidation) {
        this.id = id;
        this.inventoryType = inventoryType;
        this.merchandiseNumber = merchandiseNumber;
        this.quantity = quantity;
        this.invoiceNumber = invoiceNumber;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.assigmentToPerson = assigmentToPerson;
        this.merchandiseLiquidationDate = merchandiseLiquidationDate;
        this.methodOfGoodsDisposal = methodOfGoodsDisposal;
        this.personResponsibleForLiquidation = personResponsibleForLiquidation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public int getMerchandiseNumber() {
        return merchandiseNumber;
    }

    public void setMerchandiseNumber(int merchandiseNumber) {
        this.merchandiseNumber = merchandiseNumber;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAssigmentToPerson() {
        return assigmentToPerson;
    }

    public void setAssigmentToPerson(String assigmentToPerson) {
        this.assigmentToPerson = assigmentToPerson;
    }

    public LocalDate getMerchandiseLiquidationDate() {
        return merchandiseLiquidationDate;
    }

    public void setMerchandiseLiquidationDate(LocalDate merchandiseLiquidationDate) {
        this.merchandiseLiquidationDate = merchandiseLiquidationDate;
    }

    public String getMethodOfGoodsDisposal() {
        return methodOfGoodsDisposal;
    }

    public void setMethodOfGoodsDisposal(String methodOfGoodsDisposal) {
        this.methodOfGoodsDisposal = methodOfGoodsDisposal;
    }

    public String getPersonResponsibleForLiquidation() {
        return personResponsibleForLiquidation;
    }

    public void setPersonResponsibleForLiquidation(String personResponsibleForLiquidation) {
        this.personResponsibleForLiquidation = personResponsibleForLiquidation;
    }
}
