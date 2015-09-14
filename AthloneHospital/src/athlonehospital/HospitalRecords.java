/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athlonehospital;

import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javafx.event.ActionEvent;
import java.net.URI;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;

/**
 * Class Hospital Records allows the displaying and adding of records
 * about Patient details on a GUI from a database
 *
 * @author SCHOLES
 */
public class HospitalRecords extends javax.swing.JFrame {

    
    /**String to hold the name*/
    private String name;
     /**String to hold the address*/
    private String address;
     /**String to hold the county*/
    private String county;
     /**String to hold the dob*/
    private String dob;
    /**String to hold the nationality*/
    private String nationality;
    /**String to hold the gender*/
    private String gender;
    /**String to hold the mobile*/
    private String mobile;
    /**String to hold the pps*/
    private String pps;
    /**Integer to hold the ppsint*/
    private int ppsint;
    /**String to hold the blood*/
    private String blood;
    /**String to hold the nok*/
    private String nok;
    /**String to hold the gp*/
    private String gp;
    /**String to hold the visit*/
    private String visit;
    /**String to hold the consultant*/
    private String consultant;
    /**String to hold the reason*/
    private String reason;
    /**String to hold the diagnosis*/
    private String diagnosis;
    /**String to hold the treatment*/
    private String treatment;
    /**String to hold the xray*/
    private String xray;
    /**String to hold the mri*/
    private String mri;
    /**String to hold the ct*/
    private String ct;
    /**Integer to hold the testfee*/
    int testfee;
    /**Integer to hold the consultantfee*/
    int consultantfee;
    /**Integer to hold the totalfee*/
    private int totalfee;
    /**Integer to hold the length*/
    private int length;
    /**String to hold the medication*/
    private String medication;
    /**String to hold the follow*/
    private String follow;
    /**String to hold the consfee*/
    private String consfee;
    /**Integer to hold the consfeeint*/
    private int consfeeint;
    /**String to hold the Testfee*/
    private String Testfee;
    /**Integer to hold the Testfeeint*/
    private int Testfeeint;
    /**String to hold the medfee*/
    private String medfee;
    /**String to hold the stayfee*/
    private String stayfee;
    /**Integer to hold the medfeeint*/
    private int medfeeint;
    /**String to hold the totfee*/
    private String totfee;
    /**Integer to hold the totfeeint*/
    private int totfeeint;
    /**String to hold the medyes*/
    private String medyes;
    /**String to hold the medcardno*/
    private String medcardno;
    /**String to hold the insurance*/
    private String insurance;
    /**Integer to hold the insaccno*/
    private int insaccno;
    /**String to hold the creditcard*/
    private String creditcard;
    /**Integer to hold the credcard*/
    private int credcard;
    /**Integer to hold the i*/
      private int i;
      /**Integer to hold the b*/
    private int b;
    /**Integer to hold the invoice*/
    private int invoice;
    /**Connection to hold the con*/
    Connection con;
    /**Statement to hold the stmt*/
    Statement stmt;
    /**Statement to hold the stmt2*/
    Statement stmt2;
    /**Statement to hold the stmt3*/
    Statement stmt3;
    /**ResultSet to hold the rs*/
    ResultSet rs;
    /**ResultSet to hold the rs2*/
    ResultSet rs2;
    /**ResultSet to hold the rs3*/
    ResultSet rs3;
    /**Integer to hold the index1*/
    private int index1;
    /**String to hold the cardnost*/
    private String cardnost;
    /**Integer to hold the index2*/
    private int index2;
    /**Integer to hold the index3*/
    private int index3;
    /**String to hold the accnoSt*/
    private String accnoSt;
    /**String to hold the inv*/
    private String inv;
    /**String to hold the credcardst*/
    private String credcardst;
    /**String to hold the ccard*/
    private String ccard;
    /**String to hold the ppstofind*/
    private String ppstofind;
    /**Integer to hold the ppstofindint*/
    private int ppstofindint;
    /**Integer to hold the count*/
    int count;
    /**Integer to hold the count2*/
    int count2;
    /**Integer to hold the credcardSt*/
    private String credcardSt;
    /**Integer to hold the count3*/
    int count3;
    /**Integer to hold the current*/
    int current;
    static String user;
    

    
    /**Constructor to initialize data
     * 
     */
    public HospitalRecords() {
    name = "";
    address = "";
    county = "";
    dob = "";
    nationality = "";
    gender = "";
    mobile = "";
    pps = "";
    user = "";
    totalfee = 0;
    ppsint = 0;
    blood = "";
    ccard = "";
    nok = "";
    gp = "";
    visit = "";
    consultant = "";
    consultantfee = 0;
    reason = "";
    testfee = 0;
    diagnosis = "";
    treatment = "";
    stayfee = "";
    xray = "";
    mri = "";
    ct = "";
    length = 0;
    medication = "";
    invoice = 0;
    inv = "";
    follow = "";
    consfee = "";
    consfeeint = 0;
    Testfee = "";
    Testfeeint = 0;
    medfee = "";
    medfeeint = 0;
    totfee = "";
    totfeeint = 0;
    medyes = "";
    medcardno = "";
    insurance = "";
    accnoSt = "";
    insaccno = 0;
    creditcard = "";
    credcard = 0;
    credcardSt = "";
    con = null;
    stmt = null;
    rs = null;
    rs2 = null;
    rs3 = null;
    count = 0;
    cardnost = "";
    count2 = 0;
    count3 = 0;
    current = 0;
    index1 = 0;
    index2 = 0;
    index3 = 0;
    ppstofind = "";
    ppstofindint = 0;
    credcardst = "";
    i=0;
    b=0;
  
    initComponents();
    dbConn();
    initDB();
    }
    
    public void User (String username){
        user = username;
    }
    
    public static String getUser(){return user;}
    /**
     * Connects to a specific database
     */
    private void dbConn()
    {
	try		
	{	
			// driver to use with named database
		String url = "jdbc:ucanaccess://c:/AH/AthloneHospital.mdb";
                 
			// connection represents a session with a specific database
		con = DriverManager.getConnection(url);

			// stmt used for executing sql statements and obtaining results
		stmt = con.createStatement();

		rs = stmt.executeQuery("SELECT * FROM Patient");
                rs2 = stmt.executeQuery("SELECT * FROM Illness");
                rs3 = stmt.executeQuery("SELECT * FROM Billing");

		while(rs.next())	// count number of rows in table
			count++;
		rs.close();
                
                while(rs2.next())	// count number of rows in table
			count2++;
		rs2.close();
                
                while(rs3.next())	// count number of rows in table
			count3++;
		rs3.close();
                
             System.out.println("Yo!");
	}
	catch(Exception e) { System.out.println("Error in start up......");}
    }
    /**Initializes information from the database on the GUI
     * 
     */
    public void initDB()
    {
	try		// display database info in gui
	{
		rs = stmt.executeQuery("SELECT * FROM Patient");
		rs.next();
                rs2 = stmt.executeQuery("SELECT * FROM Illness");
		rs2.next();
                rs3 = stmt.executeQuery("SELECT * FROM Billing");
		rs3.next(); 
                System.out.println("Hello");
                name = rs.getString("Name");
                address = rs.getString("Address");
                county = rs.getString("County");
                dob = rs.getString("Date_of_Birth");
                nationality = rs.getString("Nationality");
                gender = rs.getString("Gender");
                mobile = rs.getString("Mobile");
                pps = rs.getString("PPS");
                blood = rs.getString("Blood_Type");
                nok = rs.getString("Next_of_Kin");
                gp = rs.getString("GP");
                //System.out.print(nationality);
                visit = rs2.getString("Date_of_Visit");
                consultant = rs2.getString("Consultant");
                reason = rs2.getString("Reason_for_Visit");
                diagnosis = rs2.getString("Diagnosis");
                treatment = rs2.getString("Treatment");
                xray = rs2.getString("XRay");
                mri = rs2.getString("MRI");
                ct = rs2.getString("CTScan");
                length = rs2.getInt("Length");
                medication = rs2.getString("Medication");
                follow = rs2.getString("FollowUp");
                consfee = rs3.getString("Consultant_Fee");
                Testfee = rs3.getString("Test_Fee");
                stayfee = rs3.getString("Stay_Fee");
                medfee = rs3.getString("Medication_Fee");
                totfee = rs3.getString("Total_Fee");
                inv = rs3.getString("Invoice_Number");
                medyes = rs3.getString("Medical_Card");
                medcardno = rs3.getString("Card_Number");
                insurance = rs3.getString("Insurance_Provider");
                accnoSt = rs3.getString("AccountNo");
                creditcard = rs3.getString("Credit_Card");
                credcardst =  rs3.getString("Card_No");
                System.out.println("\n"+creditcard);
                
                NameTF.setText(name);
                AddressTF.setText(address);
                CountyCombo.setSelectedItem(county);
                DOBTF.setText(dob);
                NationalityTF.setText(nationality);
                MobileTF.setText(mobile);
                PPSTF.setText(pps);
                BloodCombo.setSelectedItem(blood);
                NokTF.setText(nok);
                GPTf.setText(gp);
                VisitTF.setText(visit);
                ConsultantCombo.setSelectedItem(consultant);
                ReasonTF.setText(reason);
                DiagnosisTF.setText(diagnosis);
                TreatmentTF.setText(treatment);
                MedicationTF.setText(medication);
                FollowTF.setText(follow);
                
                if("Male".equals(gender))
                    MaleRadio.setSelected(true);
                else if ("Female".equals(gender))
                    FemaleRadio.setSelected(true);
                if ("Yes".equals(xray))
                    XRayCheck.setSelected(true);
                if ("Yes".equals(mri))
                    MRICheck.setSelected(true);
                if ("Yes".equals(ct))
                    CTCheck.setSelected(true);
                System.out.println(medyes);
                if ("Yes".equals(medyes)){
                    MedYesCheck.setSelected(true);
                    //cardnost = String.valueOf(cardno);
                    MedCardTf.setText(cardnost);
                    //InsuranceCombo.setEnabled(false);
                    //AcnoTF.setEnabled(false);
                    //CCardCombo.setEnabled(false);
                    //CardNoTf.setEnabled(false);
        }
                else if ("No".equals(medyes))
                        CardNoTf.setText(credcardSt);
                
                
                LengthSlider.setValue(length);
                //consfee = String.valueOf(consfeeint);
                FeeTF.setText(consfee);
                //Testfee = String.valueOf(Testfeeint);
                TestfeeTF.setText(Testfee);
                //medfee = String.valueOf(medfeeint);
                MedFeeTF.setText(medfee);
                StayFeeTf.setText(stayfee);
                //totfee = String.valueOf(totfeeint);
                TotalFeeTf.setText(totfee);
                //inv = String.valueOf(invoice);
                InvoiceTf.setText(inv);
                
                
                
                current = 1;
		rs.close();
                rs2.close();
                rs3.close();
	}
    catch(Exception e) {System.out.println("Error in initialising DB info to GUI");}
    }
    /**
     * Moves to a specified row in the database and displays it on the GUI
     * @param index String value to hold the specified database row
     */
        public void moveToRow(int index)
    {
	try
	{
		rs = stmt.executeQuery("SELECT * FROM Patient");
                rs2 = stmt.executeQuery("SELECT * FROM Illness");
                rs3 = stmt.executeQuery("SELECT * FROM Billing");
                
		
		for(int i = 0; i < index; i++)
			rs.next(); 
                // move to specific row in table (at index)
                for(int i = 0; i < index; i++)
			rs2.next();
                for(int i = 0; i < index; i++)
			rs3.next(); 
           
                name = rs.getString("Name");
                address = rs.getString("Address");
                county = rs.getString("County");
                dob = rs.getString("Date_of_Birth");
                nationality = rs.getString("Nationality");
                gender = rs.getString("Gender");
                mobile = rs.getString("Mobile");
                pps = rs.getString("PPS");
                blood = rs.getString("Blood_Type");
                nok = rs.getString("Next_of_Kin");
                gp = rs.getString("GP");
                //System.out.print(nationality);
                visit = rs2.getString("Date_of_Visit");
                consultant = rs2.getString("Consultant");
                reason = rs2.getString("Reason_for_Visit");
                diagnosis = rs2.getString("Diagnosis");
                treatment = rs2.getString("Treatment");
                xray = rs2.getString("XRay");
                mri = rs2.getString("MRI");
                ct = rs2.getString("CTScan");
                length = rs2.getInt("Length");
                medication = rs2.getString("Medication");
                follow = rs2.getString("FollowUp");
                consfee = rs3.getString("Consultant_Fee");
                Testfee = rs3.getString("Test_Fee");
                stayfee = rs3.getString("Stay_Fee");
                medfee = rs3.getString("Medication_Fee");
                totfee = rs3.getString("Total_Fee");
                inv = rs3.getString("Invoice_Number");
                medyes = rs3.getString("Medical_Card");
                medcardno = rs3.getString("Card_Number");
                insurance = rs3.getString("Insurance_Provider");
                accnoSt = rs3.getString("AccountNo");
                creditcard = rs3.getString("Credit_Card");
                credcardst =  rs3.getString("Card_No");
                System.out.println("\n"+creditcard);
                
                
                NameTF.setText(name);
                AddressTF.setText(address);
                CountyCombo.setSelectedItem(county);
                DOBTF.setText(dob);
                NationalityTF.setText(nationality);
                MobileTF.setText(mobile);
                //pps = String.valueOf(ppsint);
                PPSTF.setText(pps);
                BloodCombo.setSelectedItem(blood);
                NokTF.setText(nok);
                GPTf.setText(gp);
                VisitTF.setText(visit);
                ConsultantCombo.setSelectedItem(consultant);
                ReasonTF.setText(reason);
                DiagnosisTF.setText(diagnosis);
                TreatmentTF.setText(treatment);
                MedicationTF.setText(medication);
                FollowTF.setText(follow);
                
                if("Male".equals(gender))
                    MaleRadio.setSelected(true);
                else if ("Female".equals(gender))
                    FemaleRadio.setSelected(true);
                if ("Yes".equals(xray))
                    XRayCheck.setSelected(true);
                else if ("No".equals(xray))
                    XRayCheck.setSelected(false);
                if ("Yes".equals(mri))
                    MRICheck.setSelected(true);
                else if ("No".equals(mri))
                    MRICheck.setSelected(false);
                if ("Yes".equals(ct))
                    CTCheck.setSelected(true);
                else if ("No".equals(ct))
                    CTCheck.setSelected(false);
                System.out.println(medyes);
                if ("Yes".equals(medyes)){
                    MedYesCheck.setSelected(true);
                    //cardnost = String.valueOf(cardno);
                    MedCardTf.setEnabled(true);
                    MedCardTf.setText(medcardno);
                    InsuranceCombo.setEnabled(false);
                    AcnoTF.setEnabled(false);
                    CCardCombo.setEnabled(false);
                    CardNoTf.setEnabled(false);
        }
                else if ("No".equals(medyes))
                {
                    MedCardTf.setEnabled(false);
                    MedYesCheck.setSelected(false);
                    InsuranceCombo.setEnabled(true);
                    AcnoTF.setEnabled(true);
                    CCardCombo.setEnabled(true);
                    CardNoTf.setEnabled(true);
                    InsuranceCombo.setSelectedItem(insurance);
                    //accnoSt = String.valueOf(accno);
                    AcnoTF.setText(accnoSt);
                    CCardCombo.setSelectedItem(creditcard);
                    //credcardSt = String.valueOf(credcard);
                    CardNoTf.setText(credcardSt);
                }
                
                LengthSlider.setValue(length);
                //consfee = String.valueOf(consfeeint);
                FeeTF.setText(consfee);
                //Testfee = String.valueOf(Testfeeint);
                TestfeeTF.setText(Testfee);
                //medfee = String.valueOf(medfeeint);
                MedFeeTF.setText(medfee);
                //totfee = String.valueOf(totfeeint);
                StayFeeTf.setText(stayfee);
                TotalFeeTf.setText(totfee);
                //inv = String.valueOf(invoice);
                InvoiceTf.setText(inv);
                

	
        

		

		current = index;
		rs.close();
                rs2.close();
                rs3.close();
                
	}
	catch(Exception e) {System.out.println("Error in moving to row at index specified");}
    }
     /**
      * Finds the specific Customer from the database 
      * @param ppstoFind String value to hold the PPS value, i.e. the search variable
      */   
    public void findCustomer(String ppstoFind)
    {
        int foundPPS = 0;
        boolean found = false;
        System.out.println(ppstoFind);
        
        try
        {
            System.out.println("Finding: "+ppstoFind);
            rs = stmt.executeQuery("Select * FROM Patient");
            rs2 = stmt.executeQuery("Select * FROM Illness");
            rs3 = stmt.executeQuery("Select * FROM Billing");
            
            while(rs.next() && rs2.next() && rs3.next() && found == false)
            {
                foundPPS++;
                String curPPS1 = rs.getString("PPS");
                
                String curPPS2 = rs2.getString("PPS");
                String curPPS3 = rs3.getString("PPS");
                System.out.println(curPPS1+" "+curPPS2+" "+curPPS3);
                //curName.trim();
                if (curPPS1.equals(ppstoFind) && curPPS2.equals(ppstoFind) && curPPS3.equals(ppstoFind))
                    found = true;
            }
            rs.close();
            rs2.close();
            rs3.close();
        }
        catch(Exception e){System.out.println("Error finding Customer in databse");e.printStackTrace();}
        if (found == true)
            moveToRow(foundPPS);
        else{
            JOptionPane.showMessageDialog(HospitalRecords.this,
		"Not Found",
		"Hospital Records", JOptionPane.WARNING_MESSAGE);}
    }

    /**
     * Initializes the components onto the GUI.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gendergroup = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AddressTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CountyCombo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        DOBTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        NationalityTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        MaleRadio = new javax.swing.JRadioButton();
        FemaleRadio = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        MobileTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        PPSTF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        BloodCombo = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        NokTF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        GPTf = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        DiagnosisTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TreatmentTF = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        LengthSlider = new javax.swing.JSlider();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        MedicationTF = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        XRayCheck = new javax.swing.JCheckBox();
        MRICheck = new javax.swing.JCheckBox();
        CTCheck = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        VisitTF = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        ReasonTF = new javax.swing.JTextField();
        ConsultantCombo = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        FollowTF = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        MedYesCheck = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        MedCardTf = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        InsuranceCombo = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        FeeTF = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        TestfeeTF = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        MedFeeTF = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        TotalFeeTf = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        InvoiceTf = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        AcnoTF = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        CCardCombo = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        CardNoTf = new javax.swing.JTextField();
        CalcButton = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        StayFeeTf = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        SearchButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        PreviousButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        HSEButton = new javax.swing.JButton();
        IrishHealthButton = new javax.swing.JButton();
        GoogleButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        SaveMI = new javax.swing.JMenuItem();
        PasswordChange = new javax.swing.JMenuItem();
        ExitMI = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        GuideMI = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/athlonehospital/ahlogo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setForeground(new java.awt.Color(102, 255, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Patient Details");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Address:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("County:");

        CountyCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Carlow", "Cavan", "Clare", "Cork", "Donegal", "Dublin", "Galway", "Kerry", "Kildare", "Kilkenny", "Laois", "Leitrim", "Limerick", "Longford", "Louth", "Mayo", "Meath", "Monaghan", "Offaly", "Roscommon", "Sligo", "Tipperary", "Waterford", "Westmeath", "Wexford", "Wicklow" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Date of Birth:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nationality:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Gender:");

        MaleRadio.setBackground(new java.awt.Color(102, 255, 102));
        Gendergroup.add(MaleRadio);
        MaleRadio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MaleRadio.setText("M");
        MaleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleRadioActionPerformed(evt);
            }
        });

        FemaleRadio.setBackground(new java.awt.Color(102, 255, 102));
        Gendergroup.add(FemaleRadio);
        FemaleRadio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FemaleRadio.setText("F");
        FemaleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleRadioActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Mobile No:");

        MobileTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MobileTFActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("PPS Number:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Blood Type:");

        BloodCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "O Positive", "O Negative", "A Positive", "A Negative", "B Positive", "B Negative", "AB Positive", "AB Negative" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Next of Kin:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("GP:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NameTF)
                            .addComponent(AddressTF)
                            .addComponent(CountyCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DOBTF)
                            .addComponent(NationalityTF)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(MaleRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FemaleRadio))
                            .addComponent(MobileTF)
                            .addComponent(PPSTF)
                            .addComponent(BloodCombo, 0, 109, Short.MAX_VALUE)
                            .addComponent(NokTF)
                            .addComponent(GPTf)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(AddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CountyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(DOBTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(NationalityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(MaleRadio)
                    .addComponent(FemaleRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(MobileTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(PPSTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BloodCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(NokTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(GPTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 102));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Illness Details");
        jLabel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Diagnosis:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Treatment:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Length of Stay(Days):");

        LengthSlider.setBackground(new java.awt.Color(153, 255, 102));
        LengthSlider.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LengthSlider.setForeground(new java.awt.Color(0, 0, 0));
        LengthSlider.setMajorTickSpacing(5);
        LengthSlider.setMaximum(60);
        LengthSlider.setMinorTickSpacing(5);
        LengthSlider.setPaintLabels(true);
        LengthSlider.setPaintTicks(true);
        LengthSlider.setSnapToTicks(true);
        LengthSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                LengthSliderStateChanged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Consultant:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Medication:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Tests:");

        XRayCheck.setBackground(new java.awt.Color(153, 255, 102));
        XRayCheck.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        XRayCheck.setText("X-Ray");
        XRayCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XRayCheckActionPerformed(evt);
            }
        });

        MRICheck.setBackground(new java.awt.Color(153, 255, 102));
        MRICheck.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        MRICheck.setText("MRI");
        MRICheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MRICheckActionPerformed(evt);
            }
        });

        CTCheck.setBackground(new java.awt.Color(153, 255, 102));
        CTCheck.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CTCheck.setText("CT Scan");
        CTCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CTCheckActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Date of Visit:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Reason for Visit:");

        ConsultantCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dr Cox", "Dr Dorian", "Dr Kelso", "Dr Reid", "Dr Turk", "Dr Itor" }));
        ConsultantCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultantComboActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Follow Up:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TreatmentTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(44, 44, 44)
                                    .addComponent(DiagnosisTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(XRayCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MRICheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CTCheck))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                    .addComponent(VisitTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel22)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addGap(37, 37, 37)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ReasonTF)
                                        .addComponent(ConsultantCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(LengthSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MedicationTF)
                            .addComponent(FollowTF, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(VisitTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(ConsultantCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(ReasonTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiagnosisTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TreatmentTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(XRayCheck)
                    .addComponent(MRICheck)
                    .addComponent(CTCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LengthSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(MedicationTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(FollowTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel23.getAccessibleContext().setAccessibleName("Follow Up Date:");

        jPanel3.setBackground(new java.awt.Color(153, 255, 0));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Billing Information");
        jLabel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Medical Card:");

        MedYesCheck.setBackground(new java.awt.Color(153, 255, 0));
        MedYesCheck.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        MedYesCheck.setText("Yes");
        MedYesCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedYesCheckActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Card Number:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Insurance Provider:");

        InsuranceCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VHI", "Aviva", "GloHealth", "Laya", "HSF" }));
        InsuranceCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsuranceComboActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Consultant Fee:");

        FeeTF.setEditable(false);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Test Fee:");

        TestfeeTF.setEditable(false);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Medication Fee:");

        MedFeeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedFeeTFActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Total Fee:");

        TotalFeeTf.setEditable(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Invoice Number:");

        InvoiceTf.setEditable(false);
        InvoiceTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvoiceTfActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("A/C Number:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Credit Card:");

        CCardCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mastercard", "Visa" }));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Card Number:");

        CalcButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CalcButton.setText("Calculate Fee");
        CalcButton.setEnabled(false);
        CalcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcButtonActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Stay Fee:");

        StayFeeTf.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel24))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel30))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FeeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TestfeeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel31)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                    .addComponent(TotalFeeTf, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel37))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(MedFeeTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(InvoiceTf)
                                        .addComponent(StayFeeTf)))))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MedYesCheck)
                                    .addComponent(MedCardTf, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel35))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(InsuranceCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AcnoTF)
                                    .addComponent(CCardCombo, 0, 107, Short.MAX_VALUE)
                                    .addComponent(CardNoTf)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(CalcButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addComponent(FeeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MedYesCheck))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(TestfeeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MedCardTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(MedFeeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(InsuranceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(AcnoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(StayFeeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(CCardCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(TotalFeeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(CardNoTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(InvoiceTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addComponent(CalcButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 255, 153));

        SearchButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchButton.setText("Search");
        SearchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SearchButton.setSelected(true);
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        NextButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NextButton.setText("Next");
        NextButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NextButton.setSelected(true);
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        PreviousButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PreviousButton.setText("Previous");
        PreviousButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PreviousButton.setSelected(true);
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        ClearButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ClearButton.setText("Clear");
        ClearButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ClearButton.setSelected(true);
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeleteButton.setSelected(true);
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(ClearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 204, 153));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("External Links");
        jLabel38.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        HSEButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HSEButton.setText("HSE");
        HSEButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        HSEButton.setSelected(true);
        HSEButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HSEButtonActionPerformed(evt);
            }
        });

        IrishHealthButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IrishHealthButton.setText("Irish Health");
        IrishHealthButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IrishHealthButton.setSelected(true);
        IrishHealthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IrishHealthButtonActionPerformed(evt);
            }
        });

        GoogleButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        GoogleButton.setText("Google");
        GoogleButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        GoogleButton.setSelected(true);
        GoogleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoogleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(HSEButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel38)
                    .addComponent(IrishHealthButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GoogleButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HSEButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IrishHealthButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GoogleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(153, 255, 153));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setText("File");

        SaveMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SaveMI.setText("Save");
        SaveMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveMIActionPerformed(evt);
            }
        });
        jMenu1.add(SaveMI);

        PasswordChange.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        PasswordChange.setText("Change Password");
        PasswordChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordChangeActionPerformed(evt);
            }
        });
        jMenu1.add(PasswordChange);

        ExitMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        ExitMI.setText("Exit");
        ExitMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMIActionPerformed(evt);
            }
        });
        jMenu1.add(ExitMI);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        GuideMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        GuideMI.setText("User Guide");
        GuideMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuideMIActionPerformed(evt);
            }
        });
        jMenu2.add(GuideMI);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(352, 352, 352))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MobileTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobileTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MobileTFActionPerformed

    private void MedFeeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedFeeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MedFeeTFActionPerformed

    private void InvoiceTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvoiceTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InvoiceTfActionPerformed
        /**
         * Moves to the next row in the database and displays it on the GUI
         * @param evt Event listens for the button click
         */
    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        System.out.println("Current is"+current);
        System.out.println("Count is"+count);            
        if(current != count)
			moveToRow(current + 1);        // TODO add your handling code here:
    }//GEN-LAST:event_NextButtonActionPerformed
    /**
     * Moves to the previous row in the database and displays it on the GUI
     * @param evt Event listens for the button click
     */
    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        // TODO add your handling code here:
                    if(current != 1)
			moveToRow(current - 1);
    }//GEN-LAST:event_PreviousButtonActionPerformed
    /**
     * Receives from the textfield the PPS and searches for it via the FindCustomer 
     * method
     * @param evt Event listens for the button click
     */
    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
        try
		{
			String ppsst = PPSTF.getText();
                        //int ppsintt = Integer.parseInt(ppsst);
			findCustomer(ppsst);
		}
		catch(Exception e) {System.out.println("Error in find button");e.printStackTrace();}
                                             

    }//GEN-LAST:event_SearchButtonActionPerformed
    /**
     * Clears from the GUI any data that is displayed
     * @param evt Event listens for the button click
     */
    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        // TODO add your handling code here:
       
        
        NameTF.setText("");
        AddressTF.setText("");
        DOBTF.setText("");
        NationalityTF.setText("");
        MobileTF.setText("");
        PPSTF.setText("");
        NokTF.setText("");
        GPTf.setText("");
        VisitTF.setText("");
        ReasonTF.setText("");
        DiagnosisTF.setText("");
        TreatmentTF.setText("");
        XRayCheck.setSelected(false);
        MRICheck.setSelected(false);
        CTCheck.setSelected(false);
        LengthSlider.setValue(0);
        MedicationTF.setText("");
        FollowTF.setText("");
        FeeTF.setText("");
        TestfeeTF.setText("");
        MedFeeTF.setText("");
        StayFeeTf.setText(stayfee);
        TotalFeeTf.setText("");
        InvoiceTf.setText("");
        MedYesCheck.setSelected(false);
        MedCardTf.setText("");
        AcnoTF.setText("");
        CardNoTf.setText("");
        StayFeeTf.setText("");
        xray = "No";
        ct = "No";
        mri = "No";
        consultantfee = 0;
        Testfeeint = 0;
        totalfee = 0;
        CalcButton.setEnabled(true);
        
            
        
        
    }//GEN-LAST:event_ClearButtonActionPerformed
    /**
     * Sets the gender variable to Yes if this radio button is selected
     * @param evt Event listens for the radio button click
     */
    private void MaleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleRadioActionPerformed
        // TODO add your handling code here:
        if (MaleRadio.isSelected())
                gender = "Yes";
    }//GEN-LAST:event_MaleRadioActionPerformed
    /**
     * Sets the xray variable to yes if the xray check box is selected
     * If it is not selected the same variable will be set to no
     * @param evt Event listens for the button click
     */
    private void XRayCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XRayCheckActionPerformed
        // TODO add your handling code here:
       //xray = "Yes";
        if (XRayCheck.isSelected())
            xray = "Yes";
        else
            xray = "No";
       
    }//GEN-LAST:event_XRayCheckActionPerformed
    /**
     * Sets the mri variable to yes if the mri check box is selected
     * If it is not selected the same variable will be set to no
     * @param evt listens to the check box being clicked
     */
    private void MRICheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MRICheckActionPerformed
        // TODO add your handling code here:
           if (MRICheck.isSelected())
            mri = "Yes";
        else
            mri = "No";
       
    }//GEN-LAST:event_MRICheckActionPerformed
    /**
     * Sets the ct checkbox variable to yes if the ct check box is selected
     * If it is not selected the same variable will be set to no
     * @param evt listens to the check box being clicked
     */
    private void CTCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CTCheckActionPerformed
        // TODO add your handling code here:
        //ct = "Yes";
         if (CTCheck.isSelected())
            ct = "Yes";
        else
            ct = "No";
      
    }//GEN-LAST:event_CTCheckActionPerformed
    /**
     * Sets the medyes variable to yes if the MedYes check box is selected
     * If it is not selected the medyes variable is set to no
     * @param evt listens to the check box being clicked
     */
    private void MedYesCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedYesCheckActionPerformed
        // TODO add your handling code here:
        if (MedYesCheck.isSelected()){
              medyes = "Yes";
              InsuranceCombo.setEnabled(false);
              insurance = null;
              AcnoTF.setEnabled(false);
              accnoSt = null;
              CCardCombo.setEnabled(false);
              ccard = null;
             MedCardTf.setEnabled(true);
              CardNoTf.setEnabled(false);
             System.out.println("HEEEEEEERRRRRREEEE");
             
              }
          else
          {
              MedCardTf.setEnabled(false);
              medyes = "No";
              InsuranceCombo.setEnabled(true);
              AcnoTF.setEnabled(true);
              CCardCombo.setEnabled(true);
              CardNoTf.setEnabled(true);
          System.out.println("ytyjgygj");
          }
    }//GEN-LAST:event_MedYesCheckActionPerformed
    
    private void InsuranceComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsuranceComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InsuranceComboActionPerformed
    /**
     * Deletes from the database the current rows being displayed on the GUI
     * @param evt Listens to the button being clicked
     */
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        String pps = PPSTF.getText(); 
        try	// get name to delete from database, use preparedstmt with wildcard
		{
			PreparedStatement pstmt1 = con.prepareStatement("DELETE FROM Patient WHERE PPS = ?");
			pstmt1.setString(1,pps);   		//sets the wildcard parameter to doc name
			pstmt1.executeUpdate();		// execute delete

			System.out.println(pps +" deleted from database");
		}
		catch(Exception e) {System.out.println("Error in delete button");}
        try	// get name to delete from database, use preparedstmt with wildcard
		{
			PreparedStatement pstmt2 = con.prepareStatement("DELETE FROM Illness WHERE PPS = ?");
			pstmt2.setString(1,pps);   		//sets the wildcard parameter to doc name
			pstmt2.executeUpdate();		// execute delete

			System.out.println(pps +" deleted from database");
		}
		catch(Exception e) {System.out.println("Error in delete button");}
         try	// get name to delete from database, use preparedstmt with wildcard
		{
			PreparedStatement pstmt3 = con.prepareStatement("DELETE FROM Billing WHERE PPS = ?");
			pstmt3.setString(1,pps);   		//sets the wildcard parameter to doc name
			pstmt3.executeUpdate();		// execute delete

			System.out.println(pps +" deleted from database");
		}
		catch(Exception e) {System.out.println("Error in delete button");}
        
                count --;
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void ConsultantComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultantComboActionPerformed
        // TODO add your handling code here:
       
        
        
    }//GEN-LAST:event_ConsultantComboActionPerformed
    /**
     * Calculates the Consultant Fee, TestFee, Total Fee and generates
     * an invoice number
     * @param evt Listens to the button being clicked
     */
    private void CalcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcButtonActionPerformed
        // TODO add your handling code here:
        String consult = (String)ConsultantCombo.getSelectedItem();
        if (consult == "Dr Cox")
            consultantfee = 150;
        else if (consult == "Dr Kelso")
            consultantfee = 150;
         else if (consult == "Dr Dorian")
            consultantfee = 100;
         else if (consult == "Dr Turk")
            consultantfee = 100;
         else if (consult == "Dr Reid")
            consultantfee = 120;
         else if (consult == "Dr Itor")
            consultantfee = 80;
         consfee = String.valueOf(consultantfee);
         FeeTF.setText(consfee);
         
         if (xray == "Yes")
             Testfeeint += 70;
         if (mri == "Yes")
             Testfeeint += 70;
         if (ct == "Yes")
             Testfeeint += 70;
         Testfee = String.valueOf(Testfeeint);
         TestfeeTF.setText(Testfee);
         String medfee = MedFeeTF.getText();
         if (medfee.equals(""))
         {
             JOptionPane.showMessageDialog(HospitalRecords.this,
		"Med Fee is required",
		"Hospital Records", JOptionPane.WARNING_MESSAGE);}
         else
        {
         int medfeeint = 0;
         medfeeint = Integer.parseInt(medfee);
         String stayy = StayFeeTf.getText();
         int stayyy = Integer.parseInt(stayy);
         totalfee = Testfeeint + consultantfee + medfeeint+stayyy;
         
         TotalFeeTf.setText(String.valueOf(totalfee));
         Random random = new Random();
         int invoiceno = random.nextInt(1000000 - 100000 + 1) + 100000;
         System.out.println(invoiceno);
         inv = String.valueOf(invoiceno);
         InvoiceTf.setText(inv);
         totalfee = 0;
         CalcButton.setEnabled(false);
         }
         
         
         
         
         
         
         
             
        
      
    }//GEN-LAST:event_CalcButtonActionPerformed

    /**
     * Gets the value from the Slider to the length variable
     * Calculates the lengthstay fee and displays it on the GUI
     * @param evt Listens to changes on the slider
     */
    private void LengthSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_LengthSliderStateChanged
        // TODO add your handling code here:
                if (evt.getSource()== LengthSlider && !LengthSlider.getValueIsAdjusting())
                {
                length = LengthSlider.getValue();
                System.out.println(length);
                int stayfeeint = length * 25;
                String stayfee = String.valueOf(stayfeeint);
                StayFeeTf.setText(stayfee);
                }
    }//GEN-LAST:event_LengthSliderStateChanged
    /**
     * Sets the gender variable to Female this radio button is selected
     * @param evt Event listens for the radio button click
     *  
     */
    private void FemaleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleRadioActionPerformed
        // TODO add your handling code here:
        if (FemaleRadio.isSelected())
            gender = "Female";
    }//GEN-LAST:event_FemaleRadioActionPerformed
    /**
     * Opens up the Guide screen to show the user how to work the GUI
     * @param evt Listens for the button click
     */
    private void GuideMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuideMIActionPerformed
        // TODO add your handling code here:
        Guide guide = new Guide();
        guide.setVisible(true);
    }//GEN-LAST:event_GuideMIActionPerformed
    /**
     * Takes into the relevant variables the information from the GUI components
     * Then saves the information to the specified database via an 
     * SQL statement
     * @param evt Listens to the button click
     */
    private void SaveMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveMIActionPerformed
        // TODO add your handling code here:
        try
        {
            String name = NameTF.getText();
            String address = AddressTF.getText();
            String county = (String)CountyCombo.getSelectedItem();
            String dob = DOBTF.getText();
            String nationality = NationalityTF.getText();
            String mobile = MobileTF.getText();
            String ppsst = PPSTF.getText();
            //int ppsint = Integer.parseInt(pps);
            String blood = (String)BloodCombo.getSelectedItem();
            String noktf = NokTF.getText();
            String gp = GPTf.getText();
            String newPatient = "Insert into Patient(Name,Address,County,Date_of_Birth,Nationality,Gender,Mobile,PPS,Blood_Type,Next_of_Kin,GP)VALUES('"+name+"','"+address+"','"+county+"','"+dob+"','"+nationality+"','"+gender+"','"+mobile+"','"+ppsst+"','"+blood+"','"+noktf+"','"+gp+"')";
            stmt.executeUpdate(newPatient);
            System.out.println(name+" stored in Patient table");
        }
        catch(Exception e){System.out.println("Error in creating new Patient in database");e.printStackTrace();}
        try{
            String visit = VisitTF.getText();
            String consult = (String)ConsultantCombo.getSelectedItem();
            String reason = ReasonTF.getText();
            String diagnos = DiagnosisTF.getText();
            String treat = TreatmentTF.getText();
            String ppsst = PPSTF.getText();
            String med = MedicationTF.getText();
            String follow = FollowTF.getText();
            System.out.println("xray"+xray);
            String newillness = "Insert into Illness(Date_of_Visit,Consultant,Reason_for_Visit,Diagnosis,Treatment,XRay,MRI,CTScan,Length,Medication,FollowUp,PPS)VALUES('"+visit+"','"+consult+"','"+reason+"','"+diagnos+"','"+treat+"','"+xray+"','"+mri+"','"+ct+"','"+length+"','"+med+"','"+follow+"','"+ppsst+"')";
            stmt.executeUpdate(newillness);
            System.out.println(visit+" stored in Illness table");
        }
        catch(Exception e){System.out.println("Error in creating new row in Illness table"); e.printStackTrace();}
        try{
            String fee = FeeTF.getText();
           System.out.println("here"+fee);
            String testfee = TestfeeTF.getText();
           
            String medfee = MedFeeTF.getText();
            String stayfee = StayFeeTf.getText();
            String tot = TotalFeeTf.getText();
             String ppsst = PPSTF.getText();
            
            String inv = InvoiceTf.getText();
            
            String card = "";
            if (MedCardTf.isEnabled())
                 card = MedCardTf.getText();
            else
                card = null;
            
            String insur = "";
            if (InsuranceCombo.isEnabled())
            {
               insur = (String)InsuranceCombo.getSelectedItem();
            }
            else
                insur = null;
            String accno = "";
            if (AcnoTF.isEnabled())
                 accno = AcnoTF.getText();
            else 
                accno = null;
          
            String ccard = "";
            if (CCardCombo.isEnabled())
                ccard = (String)CCardCombo.getSelectedItem();
            else 
                ccard = null;
            //String ccardno = "";
            if (CardNoTf.isEnabled())
                credcardst = CardNoTf.getText();
            else
                credcardst = null;
           
            String newbilling = "Insert into Billing(Invoice_Number,Consultant_Fee,Test_Fee,Stay_Fee,Medication_Fee,Total_Fee,Medical_Card,Card_Number,Insurance_Provider,AccountNo,Credit_Card,Card_No,PPS)Values('"+inv+"','"+fee+"','"+testfee+"','"+stayfee+"','"+medfee+"','"+tot+"','"+medyes+"','"+card+"','"+insur+"','"+accno+"','"+ccard+"','"+credcardst+"','"+ppsst+"')";
            stmt.executeUpdate(newbilling);
            System.out.println(inv+" stored in Billing table");
            
            
            
            
        }
        catch(Exception e){System.out.println("Error in creating new Billing row in database");e.printStackTrace();}
        count++;
        JOptionPane.showMessageDialog(HospitalRecords.this,
		"Saved Successful!",
		"Hospital Records", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_SaveMIActionPerformed
    /**
     * Listens for the Exit Button being clicked
     * @param evt 
     */
    private void ExitMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMIActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitMIActionPerformed

    private void HSEButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HSEButtonActionPerformed
        // TODO add your handling code here:
      String url = "http://www.hse.ie";
      try
      {
      if(Desktop.isDesktopSupported())
      {
          Desktop.getDesktop().browse(new URI(url));
      }
      }
     catch(Exception e){e.printStackTrace();}
        
    }//GEN-LAST:event_HSEButtonActionPerformed

    private void IrishHealthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IrishHealthButtonActionPerformed
        // TODO add your handling code here:
         String url = "http://www.irishhealth.ie";
         try
      {
      if(Desktop.isDesktopSupported())
      {
          Desktop.getDesktop().browse(new URI(url));
      }
      }
     catch(Exception e){e.printStackTrace();}
    }//GEN-LAST:event_IrishHealthButtonActionPerformed

    private void GoogleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoogleButtonActionPerformed
        // TODO add your handling code here:
            String url = "http://www.google.ie";
         try
      {
      if(Desktop.isDesktopSupported())
      {
          Desktop.getDesktop().browse(new URI(url));
      }
      }
     catch(Exception e){e.printStackTrace();}
    }//GEN-LAST:event_GoogleButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        About about = new About();
        about.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void PasswordChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordChangeActionPerformed
        // TODO add your handling code here:
        PasswordChange pc = new PasswordChange();
        pc.setVisible(true);
    }//GEN-LAST:event_PasswordChangeActionPerformed

    /*
     public void ActionPerformed(ActionEvent event){
          if (XRayCheck.isSelected())
              xray = "Yes";
          else
              xray = "No";
          if (MRICheck.isSelected())
              mri = "Yes";
          else
              mri = "No";
          if (CTCheck.isSelected())
              ct = "Yes";
          else
              ct = "No";
         
          
                   
     }
     public void stateChanged(ChangeEvent e)
    {
    	Object target = e.getSource();

    	if(target == LengthSlider && !LengthSlider.getValueIsAdjusting())
    	{
    		length = LengthSlider.getValue();
                int stayfeeint = length * 25;
                String stayfee = String.valueOf(stayfeeint);
                StayFeeTf.setText(stayfee);
                
    	}
        
    }
     */
    /**Main is the starting point of the program
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HospitalRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HospitalRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HospitalRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HospitalRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HospitalRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AcnoTF;
    private javax.swing.JTextField AddressTF;
    private javax.swing.JComboBox BloodCombo;
    private javax.swing.JComboBox CCardCombo;
    private javax.swing.JCheckBox CTCheck;
    private javax.swing.JButton CalcButton;
    private javax.swing.JTextField CardNoTf;
    private javax.swing.JButton ClearButton;
    private javax.swing.JComboBox ConsultantCombo;
    private javax.swing.JComboBox CountyCombo;
    private javax.swing.JTextField DOBTF;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField DiagnosisTF;
    private javax.swing.JMenuItem ExitMI;
    private javax.swing.JTextField FeeTF;
    private javax.swing.JRadioButton FemaleRadio;
    private javax.swing.JTextField FollowTF;
    private javax.swing.JTextField GPTf;
    private javax.swing.ButtonGroup Gendergroup;
    private javax.swing.JButton GoogleButton;
    private javax.swing.JMenuItem GuideMI;
    private javax.swing.JButton HSEButton;
    private javax.swing.JComboBox InsuranceCombo;
    private javax.swing.JTextField InvoiceTf;
    private javax.swing.JButton IrishHealthButton;
    private javax.swing.JSlider LengthSlider;
    private javax.swing.JCheckBox MRICheck;
    private javax.swing.JRadioButton MaleRadio;
    private javax.swing.JTextField MedCardTf;
    private javax.swing.JTextField MedFeeTF;
    private javax.swing.JCheckBox MedYesCheck;
    private javax.swing.JTextField MedicationTF;
    private javax.swing.JTextField MobileTF;
    private javax.swing.JTextField NameTF;
    private javax.swing.JTextField NationalityTF;
    private javax.swing.JButton NextButton;
    private javax.swing.JTextField NokTF;
    private javax.swing.JTextField PPSTF;
    private javax.swing.JMenuItem PasswordChange;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JTextField ReasonTF;
    private javax.swing.JMenuItem SaveMI;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField StayFeeTf;
    private javax.swing.JTextField TestfeeTF;
    private javax.swing.JTextField TotalFeeTf;
    private javax.swing.JTextField TreatmentTF;
    private javax.swing.JTextField VisitTF;
    private javax.swing.JCheckBox XRayCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
