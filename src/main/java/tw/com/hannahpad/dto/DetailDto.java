package tw.com.hannahpad.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class DetailDto implements Serializable {

    private String imgBarCode1;
    private String lblBarCode1;

    private String imgBarCode2;
    private String lblBarCode2;

    private String imgBarCode3;
    private String lblBarCode3;

    private String lblC2BPinCode1; // 交貨便服務代碼

    private String qrcode;

    private String lblRecvshop1; // 取件門市
    private String lblRecver1; // 取件人

    private String lblBarCode4; // 物流專用條碼
    private String lblDeadDateTime1; // 繳費期限
    private String lblPaymentCPName1; // 廠商名稱
    private String lblOrderNo; // 寄件訂單編號
    private String lblShopperName1; // 寄件人

    @Override
    public String toString() {
        ReflectionToStringBuilder sb = new ReflectionToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
        return sb.toString();
    }

    public String getImgBarCode1() {
        return imgBarCode1;
    }

    public void setImgBarCode1(String imgBarCode1) {
        this.imgBarCode1 = imgBarCode1;
    }

    public String getLblBarCode1() {
        return lblBarCode1;
    }

    public void setLblBarCode1(String lblBarCode1) {
        this.lblBarCode1 = lblBarCode1;
    }

    public String getImgBarCode2() {
        return imgBarCode2;
    }

    public void setImgBarCode2(String imgBarCode2) {
        this.imgBarCode2 = imgBarCode2;
    }

    public String getLblBarCode2() {
        return lblBarCode2;
    }

    public void setLblBarCode2(String lblBarCode2) {
        this.lblBarCode2 = lblBarCode2;
    }

    public String getImgBarCode3() {
        return imgBarCode3;
    }

    public void setImgBarCode3(String imgBarCode3) {
        this.imgBarCode3 = imgBarCode3;
    }

    public String getLblBarCode3() {
        return lblBarCode3;
    }

    public void setLblBarCode3(String lblBarCode3) {
        this.lblBarCode3 = lblBarCode3;
    }

    public String getLblC2BPinCode1() {
        return lblC2BPinCode1;
    }

    public void setLblC2BPinCode1(String lblC2BPinCode1) {
        this.lblC2BPinCode1 = lblC2BPinCode1;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getLblRecvshop1() {
        return lblRecvshop1;
    }

    public void setLblRecvshop1(String lblRecvshop1) {
        this.lblRecvshop1 = lblRecvshop1;
    }

    public String getLblRecver1() {
        return lblRecver1;
    }

    public void setLblRecver1(String lblRecver1) {
        this.lblRecver1 = lblRecver1;
    }

    public String getLblBarCode4() {
        return lblBarCode4;
    }

    public void setLblBarCode4(String lblBarCode4) {
        this.lblBarCode4 = lblBarCode4;
    }

    public String getLblDeadDateTime1() {
        return lblDeadDateTime1;
    }

    public void setLblDeadDateTime1(String lblDeadDateTime1) {
        this.lblDeadDateTime1 = lblDeadDateTime1;
    }

    public String getLblPaymentCPName1() {
        return lblPaymentCPName1;
    }

    public void setLblPaymentCPName1(String lblPaymentCPName1) {
        this.lblPaymentCPName1 = lblPaymentCPName1;
    }

    public String getLblOrderNo() {
        return lblOrderNo;
    }

    public void setLblOrderNo(String lblOrderNo) {
        this.lblOrderNo = lblOrderNo;
    }

    public String getLblShopperName1() {
        return lblShopperName1;
    }

    public void setLblShopperName1(String lblShopperName1) {
        this.lblShopperName1 = lblShopperName1;
    }
}
