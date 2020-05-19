import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class temporary {


    private static int key = 0;
    private static int ID = 0;
    private static int index = 0;

    Border border1 = BorderFactory.createLineBorder(Color.black);
    Border border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, null, null, null);
    private JButton JBTN_Select, JBTN_Unselect, JBTN_Select1, JBTN_Unselect1, JBTN_Select2, JBTN_Unselect2, JBTN_Select3, JBTN_Unselect3, JBTN_Select4, JBTN_Unselect4, JBTN_Select5, JBTN_Unselect5, JBTN_Select6, JBTN_Unselect6;
    private JLabel JLBL_Naam, JLBL_Type, JLBL_Beschikbaarheid, JLBL_Prijs, JLBL_Processorb, JLBL_Diskruimte, JLBL_I_Type, JLBL_I_Beschikbaarheid, JLBL_I_Prijs, JLBL_I_Proccesb,
            JLBL_I_Diskruimte, JLBL_NetworkLoad, JLBL_I_NetworkLoad, JLBL_Placeholder;
    private JSeparator SEPA_Top, SEPA_Midt, SEPA_Midb, SEPA_Bottom;
    private JPanel PNL_Component;

    private PreparedStatement pstmt;
    private Statement stmt;
    private Connection con = Connectie.getConnection();
    private ComponentLijst CL;

    public temporary() throws SQLException {

        // Panel 1
        PNL_Component = new JPanel();
        PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
        PNL_Component.setPreferredSize(new Dimension(200, 185));
        PNL_Component.setBackground(Color.lightGray);
        PNL_Component.setLayout(new FlowLayout());
        CL.add(PNL_Component);

        JLBL_Naam = new JLabel((naamOphalen(1, con)));
        JLBL_Naam.setBorder(border2);
        JLBL_Naam.setPreferredSize(new Dimension(130, 20));
        JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
        PNL_Component.add(JLBL_Naam);

        JLBL_Placeholder = new JLabel("  ");
        PNL_Component.add(JLBL_Placeholder);


        JBTN_Unselect = new JButton("-");
        JBTN_Unselect.setFont(new Font("", Font.BOLD, 14));
        JBTN_Unselect.setPreferredSize(new Dimension(20, 20));
        JBTN_Unselect.setMargin(new Insets(0, 0, 1, 1));
        JBTN_Unselect.setFocusable(false);
        PNL_Component.add(JBTN_Unselect);


        JBTN_Select = new JButton("+");
        JBTN_Select.setFont(new Font("", Font.BOLD, 14));
        JBTN_Select.setPreferredSize(new Dimension(20, 20));
        JBTN_Select.setMargin(new Insets(0, 0, 1, 0));
        JBTN_Select.addActionListener(CL);
        JBTN_Select.setFocusable(false);
        PNL_Component.add(JBTN_Select);


        JLBL_Type = new JLabel("Type");
        PNL_Component.add(JLBL_Type);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Type = new JLabel(typeOphalen(1, con));
        JLBL_I_Type.setBorder(border1);
        JLBL_I_Type.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Type);

        SEPA_Top = new JSeparator();
        SEPA_Top.setPreferredSize(new Dimension(190, 1));
        SEPA_Top.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Top);

        JLBL_Beschikbaarheid = new JLabel("Beschikbaarheid");
        PNL_Component.add(JLBL_Beschikbaarheid);

        JLBL_Placeholder = new JLabel("     ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Beschikbaarheid = new JLabel(getgegevens(con, 1)[2]);
        JLBL_I_Beschikbaarheid.setBorder(border1);
        JLBL_I_Beschikbaarheid.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Beschikbaarheid);

        SEPA_Midt = new JSeparator();
        SEPA_Midt.setPreferredSize(new Dimension(190, 1));
        SEPA_Midt.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midt);

        JLBL_Prijs = new JLabel("Prijs");
        PNL_Component.add(JLBL_Prijs);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Prijs = new JLabel(getgegevens(con, 1)[3]);
        JLBL_I_Prijs.setBorder(border1);
        JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Prijs);

        SEPA_Midb = new JSeparator();
        SEPA_Midb.setPreferredSize(new Dimension(190, 1));
        SEPA_Midb.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midb);

        JLBL_Processorb = new JLabel("Processorbelasting ");
        PNL_Component.add(JLBL_Processorb);

        JLBL_I_Proccesb = new JLabel();
        JLBL_I_Proccesb.setBorder(border1);
        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Proccesb);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
        PNL_Component.add(JLBL_Diskruimte);

        JLBL_Placeholder = new JLabel("");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Diskruimte = new JLabel();
        JLBL_I_Diskruimte.setBorder(border1);
        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Diskruimte);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_NetworkLoad = new JLabel("Networkload");
        PNL_Component.add(JLBL_NetworkLoad);

        JLBL_Placeholder = new JLabel("             ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_NetworkLoad = new JLabel();
        JLBL_I_NetworkLoad.setBorder(border1);
        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_NetworkLoad);

        // Panel 2
        PNL_Component = new JPanel();
        PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
        PNL_Component.setPreferredSize(new Dimension(200, 185));
        PNL_Component.setBackground(Color.lightGray);
        PNL_Component.setLayout(new FlowLayout());
        CL.add(PNL_Component);

        JLBL_Naam = new JLabel((naamOphalen(2, con)));
        JLBL_Naam.setBorder(border2);
        JLBL_Naam.setPreferredSize(new Dimension(130, 20));
        JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
        PNL_Component.add(JLBL_Naam);

        JLBL_Placeholder = new JLabel("  ");
        PNL_Component.add(JLBL_Placeholder);


        JBTN_Unselect1 = new JButton("-");
        JBTN_Unselect1.setFont(new Font("", Font.BOLD, 14));
        JBTN_Unselect1.setPreferredSize(new Dimension(20, 20));
        JBTN_Unselect1.setMargin(new Insets(0, 0, 1, 1));
        JBTN_Unselect1.setFocusable(false);
        PNL_Component.add(JBTN_Unselect1);


        JBTN_Select1 = new JButton("+");
        JBTN_Select1.setFont(new Font("", Font.BOLD, 14));
        JBTN_Select1.setPreferredSize(new Dimension(20, 20));
        JBTN_Select1.setMargin(new Insets(0, 0, 1, 0));
        JBTN_Select1.addActionListener(CL);
        JBTN_Select1.setFocusable(false);
        PNL_Component.add(JBTN_Select1);


        JLBL_Type = new JLabel("Type");
        PNL_Component.add(JLBL_Type);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Type = new JLabel(typeOphalen(2, con));
        JLBL_I_Type.setBorder(border1);
        JLBL_I_Type.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Type);

        SEPA_Top = new JSeparator();
        SEPA_Top.setPreferredSize(new Dimension(190, 1));
        SEPA_Top.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Top);

        JLBL_Beschikbaarheid = new JLabel("Beschikbaarheid");
        PNL_Component.add(JLBL_Beschikbaarheid);

        JLBL_Placeholder = new JLabel("     ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Beschikbaarheid = new JLabel(getgegevens(con, 2)[2]);
        JLBL_I_Beschikbaarheid.setBorder(border1);
        JLBL_I_Beschikbaarheid.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Beschikbaarheid);

        SEPA_Midt = new JSeparator();
        SEPA_Midt.setPreferredSize(new Dimension(190, 1));
        SEPA_Midt.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midt);

        JLBL_Prijs = new JLabel("Prijs");
        PNL_Component.add(JLBL_Prijs);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Prijs = new JLabel(getgegevens(con, 2)[3]);
        JLBL_I_Prijs.setBorder(border1);
        JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Prijs);

        SEPA_Midb = new JSeparator();
        SEPA_Midb.setPreferredSize(new Dimension(190, 1));
        SEPA_Midb.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midb);

        JLBL_Processorb = new JLabel("Processorbelasting ");
        PNL_Component.add(JLBL_Processorb);

        JLBL_I_Proccesb = new JLabel();
        JLBL_I_Proccesb.setBorder(border1);
        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Proccesb);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
        PNL_Component.add(JLBL_Diskruimte);

        JLBL_Placeholder = new JLabel("");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Diskruimte = new JLabel();
        JLBL_I_Diskruimte.setBorder(border1);
        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Diskruimte);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_NetworkLoad = new JLabel("Networkload");
        PNL_Component.add(JLBL_NetworkLoad);

        JLBL_Placeholder = new JLabel("             ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_NetworkLoad = new JLabel();
        JLBL_I_NetworkLoad.setBorder(border1);
        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_NetworkLoad);

        // Panel 3
        PNL_Component = new JPanel();
        PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
        PNL_Component.setPreferredSize(new Dimension(200, 185));
        PNL_Component.setBackground(Color.lightGray);
        PNL_Component.setLayout(new FlowLayout());
        CL.add(PNL_Component);

        JLBL_Naam = new JLabel((naamOphalen(3, con)));
        JLBL_Naam.setBorder(border2);
        JLBL_Naam.setPreferredSize(new Dimension(130, 20));
        JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
        PNL_Component.add(JLBL_Naam);

        JLBL_Placeholder = new JLabel("  ");
        PNL_Component.add(JLBL_Placeholder);


        JBTN_Unselect2 = new JButton("-");
        JBTN_Unselect2.setFont(new Font("", Font.BOLD, 14));
        JBTN_Unselect2.setPreferredSize(new Dimension(20, 20));
        JBTN_Unselect2.setMargin(new Insets(0, 0, 1, 1));
        JBTN_Unselect2.setFocusable(false);
        PNL_Component.add(JBTN_Unselect2);


        JBTN_Select2 = new JButton("+");
        JBTN_Select2.setFont(new Font("", Font.BOLD, 14));
        JBTN_Select2.setPreferredSize(new Dimension(20, 20));
        JBTN_Select2.setMargin(new Insets(0, 0, 1, 0));
        JBTN_Select2.addActionListener(CL);
        JBTN_Select2.setFocusable(false);
        PNL_Component.add(JBTN_Select2);


        JLBL_Type = new JLabel("Type");
        PNL_Component.add(JLBL_Type);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Type = new JLabel(typeOphalen(3, con));
        JLBL_I_Type.setBorder(border1);
        JLBL_I_Type.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Type);

        SEPA_Top = new JSeparator();
        SEPA_Top.setPreferredSize(new Dimension(190, 1));
        SEPA_Top.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Top);

        JLBL_Beschikbaarheid = new JLabel("Beschikbaarheid");
        PNL_Component.add(JLBL_Beschikbaarheid);

        JLBL_Placeholder = new JLabel("     ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Beschikbaarheid = new JLabel(getgegevens(con, 3)[2]);
        JLBL_I_Beschikbaarheid.setBorder(border1);
        JLBL_I_Beschikbaarheid.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Beschikbaarheid);

        SEPA_Midt = new JSeparator();
        SEPA_Midt.setPreferredSize(new Dimension(190, 1));
        SEPA_Midt.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midt);

        JLBL_Prijs = new JLabel("Prijs");
        PNL_Component.add(JLBL_Prijs);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Prijs = new JLabel(getgegevens(con, 3)[3]);
        JLBL_I_Prijs.setBorder(border1);
        JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Prijs);

        SEPA_Midb = new JSeparator();
        SEPA_Midb.setPreferredSize(new Dimension(190, 1));
        SEPA_Midb.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midb);

        JLBL_Processorb = new JLabel("Processorbelasting ");
        PNL_Component.add(JLBL_Processorb);

        JLBL_I_Proccesb = new JLabel();
        JLBL_I_Proccesb.setBorder(border1);
        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Proccesb);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
        PNL_Component.add(JLBL_Diskruimte);

        JLBL_Placeholder = new JLabel("");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Diskruimte = new JLabel();
        JLBL_I_Diskruimte.setBorder(border1);
        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Diskruimte);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_NetworkLoad = new JLabel("Networkload");
        PNL_Component.add(JLBL_NetworkLoad);

        JLBL_Placeholder = new JLabel("             ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_NetworkLoad = new JLabel();
        JLBL_I_NetworkLoad.setBorder(border1);
        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_NetworkLoad);

        // Panel 4
        PNL_Component = new JPanel();
        PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
        PNL_Component.setPreferredSize(new Dimension(200, 185));
        PNL_Component.setBackground(Color.lightGray);
        PNL_Component.setLayout(new FlowLayout());
        CL.add(PNL_Component);

        JLBL_Naam = new JLabel((naamOphalen(4, con)));
        JLBL_Naam.setBorder(border2);
        JLBL_Naam.setPreferredSize(new Dimension(130, 20));
        JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
        PNL_Component.add(JLBL_Naam);

        JLBL_Placeholder = new JLabel("  ");
        PNL_Component.add(JLBL_Placeholder);


        JBTN_Unselect3 = new JButton("-");
        JBTN_Unselect3.setFont(new Font("", Font.BOLD, 14));
        JBTN_Unselect3.setPreferredSize(new Dimension(20, 20));
        JBTN_Unselect3.setMargin(new Insets(0, 0, 1, 1));
        JBTN_Unselect3.setFocusable(false);
        PNL_Component.add(JBTN_Unselect3);


        JBTN_Select3 = new JButton("+");
        JBTN_Select3.setFont(new Font("", Font.BOLD, 14));
        JBTN_Select3.setPreferredSize(new Dimension(20, 20));
        JBTN_Select3.setMargin(new Insets(0, 0, 1, 0));
        JBTN_Select3.addActionListener(CL);
        JBTN_Select3.setFocusable(false);
        PNL_Component.add(JBTN_Select3);


        JLBL_Type = new JLabel("Type");
        PNL_Component.add(JLBL_Type);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Type = new JLabel(typeOphalen(4, con));
        JLBL_I_Type.setBorder(border1);
        JLBL_I_Type.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Type);

        SEPA_Top = new JSeparator();
        SEPA_Top.setPreferredSize(new Dimension(190, 1));
        SEPA_Top.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Top);

        JLBL_Beschikbaarheid = new JLabel("Beschikbaarheid");
        PNL_Component.add(JLBL_Beschikbaarheid);

        JLBL_Placeholder = new JLabel("     ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Beschikbaarheid = new JLabel(getgegevens(con, 4)[2]);
        JLBL_I_Beschikbaarheid.setBorder(border1);
        JLBL_I_Beschikbaarheid.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Beschikbaarheid);

        SEPA_Midt = new JSeparator();
        SEPA_Midt.setPreferredSize(new Dimension(190, 1));
        SEPA_Midt.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midt);

        JLBL_Prijs = new JLabel("Prijs");
        PNL_Component.add(JLBL_Prijs);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Prijs = new JLabel(getgegevens(con, 4)[3]);
        JLBL_I_Prijs.setBorder(border1);
        JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Prijs);

        SEPA_Midb = new JSeparator();
        SEPA_Midb.setPreferredSize(new Dimension(190, 1));
        SEPA_Midb.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midb);

        JLBL_Processorb = new JLabel("Processorbelasting ");
        PNL_Component.add(JLBL_Processorb);

        JLBL_I_Proccesb = new JLabel();
        JLBL_I_Proccesb.setBorder(border1);
        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Proccesb);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
        PNL_Component.add(JLBL_Diskruimte);

        JLBL_Placeholder = new JLabel("");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Diskruimte = new JLabel();
        JLBL_I_Diskruimte.setBorder(border1);
        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Diskruimte);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_NetworkLoad = new JLabel("Networkload");
        PNL_Component.add(JLBL_NetworkLoad);

        JLBL_Placeholder = new JLabel("             ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_NetworkLoad = new JLabel();
        JLBL_I_NetworkLoad.setBorder(border1);
        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_NetworkLoad);

        // Panel 5
        PNL_Component = new JPanel();
        PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
        PNL_Component.setPreferredSize(new Dimension(200, 185));
        PNL_Component.setBackground(Color.lightGray);
        PNL_Component.setLayout(new FlowLayout());
        CL.add(PNL_Component);

        JLBL_Naam = new JLabel((naamOphalen(5, con)));
        JLBL_Naam.setBorder(border2);
        JLBL_Naam.setPreferredSize(new Dimension(130, 20));
        JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
        PNL_Component.add(JLBL_Naam);

        JLBL_Placeholder = new JLabel("  ");
        PNL_Component.add(JLBL_Placeholder);


        JBTN_Unselect4 = new JButton("-");
        JBTN_Unselect4.setFont(new Font("", Font.BOLD, 14));
        JBTN_Unselect4.setPreferredSize(new Dimension(20, 20));
        JBTN_Unselect4.setMargin(new Insets(0, 0, 1, 1));
        JBTN_Unselect4.setFocusable(false);
        PNL_Component.add(JBTN_Unselect4);


        JBTN_Select4 = new JButton("+");
        JBTN_Select4.setFont(new Font("", Font.BOLD, 14));
        JBTN_Select4.setPreferredSize(new Dimension(20, 20));
        JBTN_Select4.setMargin(new Insets(0, 0, 1, 0));
        JBTN_Select4.addActionListener(CL);
        JBTN_Select4.setFocusable(false);
        PNL_Component.add(JBTN_Select4);


        JLBL_Type = new JLabel("Type");
        PNL_Component.add(JLBL_Type);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Type = new JLabel(typeOphalen(5, con));
        JLBL_I_Type.setBorder(border1);
        JLBL_I_Type.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Type);

        SEPA_Top = new JSeparator();
        SEPA_Top.setPreferredSize(new Dimension(190, 1));
        SEPA_Top.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Top);

        JLBL_Beschikbaarheid = new JLabel("Beschikbaarheid");
        PNL_Component.add(JLBL_Beschikbaarheid);

        JLBL_Placeholder = new JLabel("     ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Beschikbaarheid = new JLabel(getgegevens(con, 5)[2]);
        JLBL_I_Beschikbaarheid.setBorder(border1);
        JLBL_I_Beschikbaarheid.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Beschikbaarheid);

        SEPA_Midt = new JSeparator();
        SEPA_Midt.setPreferredSize(new Dimension(190, 1));
        SEPA_Midt.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midt);

        JLBL_Prijs = new JLabel("Prijs");
        PNL_Component.add(JLBL_Prijs);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Prijs = new JLabel(getgegevens(con, 5)[3]);
        JLBL_I_Prijs.setBorder(border1);
        JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Prijs);

        SEPA_Midb = new JSeparator();
        SEPA_Midb.setPreferredSize(new Dimension(190, 1));
        SEPA_Midb.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midb);

        JLBL_Processorb = new JLabel("Processorbelasting ");
        PNL_Component.add(JLBL_Processorb);

        JLBL_I_Proccesb = new JLabel();
        JLBL_I_Proccesb.setBorder(border1);
        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Proccesb);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
        PNL_Component.add(JLBL_Diskruimte);

        JLBL_Placeholder = new JLabel("");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Diskruimte = new JLabel();
        JLBL_I_Diskruimte.setBorder(border1);
        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Diskruimte);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_NetworkLoad = new JLabel("Networkload");
        PNL_Component.add(JLBL_NetworkLoad);

        JLBL_Placeholder = new JLabel("             ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_NetworkLoad = new JLabel();
        JLBL_I_NetworkLoad.setBorder(border1);
        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_NetworkLoad);

        // Panel 6
        PNL_Component = new JPanel();
        PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
        PNL_Component.setPreferredSize(new Dimension(200, 185));
        PNL_Component.setBackground(Color.lightGray);
        PNL_Component.setLayout(new FlowLayout());
        CL.add(PNL_Component);

        JLBL_Naam = new JLabel((naamOphalen(6, con)));
        JLBL_Naam.setBorder(border2);
        JLBL_Naam.setPreferredSize(new Dimension(130, 20));
        JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
        PNL_Component.add(JLBL_Naam);

        JLBL_Placeholder = new JLabel("  ");
        PNL_Component.add(JLBL_Placeholder);


        JBTN_Unselect5 = new JButton("-");
        JBTN_Unselect5.setFont(new Font("", Font.BOLD, 14));
        JBTN_Unselect5.setPreferredSize(new Dimension(20, 20));
        JBTN_Unselect5.setMargin(new Insets(0, 0, 1, 1));
        JBTN_Unselect5.setFocusable(false);
        PNL_Component.add(JBTN_Unselect5);


        JBTN_Select5 = new JButton("+");
        JBTN_Select5.setFont(new Font("", Font.BOLD, 14));
        JBTN_Select5.setPreferredSize(new Dimension(20, 20));
        JBTN_Select5.setMargin(new Insets(0, 0, 1, 0));
        JBTN_Select5.addActionListener(CL);
        JBTN_Select5.setFocusable(false);
        PNL_Component.add(JBTN_Select5);


        JLBL_Type = new JLabel("Type");
        PNL_Component.add(JLBL_Type);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Type = new JLabel(typeOphalen(6, con));
        JLBL_I_Type.setBorder(border1);
        JLBL_I_Type.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Type);

        SEPA_Top = new JSeparator();
        SEPA_Top.setPreferredSize(new Dimension(190, 1));
        SEPA_Top.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Top);

        JLBL_Beschikbaarheid = new JLabel("Beschikbaarheid");
        PNL_Component.add(JLBL_Beschikbaarheid);

        JLBL_Placeholder = new JLabel("     ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Beschikbaarheid = new JLabel(getgegevens(con, 6)[2]);
        JLBL_I_Beschikbaarheid.setBorder(border1);
        JLBL_I_Beschikbaarheid.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Beschikbaarheid);

        SEPA_Midt = new JSeparator();
        SEPA_Midt.setPreferredSize(new Dimension(190, 1));
        SEPA_Midt.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midt);

        JLBL_Prijs = new JLabel("Prijs");
        PNL_Component.add(JLBL_Prijs);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Prijs = new JLabel(getgegevens(con, 6)[3]);
        JLBL_I_Prijs.setBorder(border1);
        JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Prijs);

        SEPA_Midb = new JSeparator();
        SEPA_Midb.setPreferredSize(new Dimension(190, 1));
        SEPA_Midb.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midb);

        JLBL_Processorb = new JLabel("Processorbelasting ");
        PNL_Component.add(JLBL_Processorb);

        JLBL_I_Proccesb = new JLabel();
        JLBL_I_Proccesb.setBorder(border1);
        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Proccesb);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
        PNL_Component.add(JLBL_Diskruimte);

        JLBL_Placeholder = new JLabel("");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Diskruimte = new JLabel();
        JLBL_I_Diskruimte.setBorder(border1);
        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Diskruimte);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_NetworkLoad = new JLabel("Networkload");
        PNL_Component.add(JLBL_NetworkLoad);

        JLBL_Placeholder = new JLabel("             ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_NetworkLoad = new JLabel();
        JLBL_I_NetworkLoad.setBorder(border1);
        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_NetworkLoad);

        // Panel 7
        PNL_Component = new JPanel();
        PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
        PNL_Component.setPreferredSize(new Dimension(200, 185));
        PNL_Component.setBackground(Color.lightGray);
        PNL_Component.setLayout(new FlowLayout());
        CL.add(PNL_Component);

        JLBL_Naam = new JLabel((naamOphalen(7, con)));
        JLBL_Naam.setBorder(border2);
        JLBL_Naam.setPreferredSize(new Dimension(130, 20));
        JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
        PNL_Component.add(JLBL_Naam);

        JLBL_Placeholder = new JLabel("  ");
        PNL_Component.add(JLBL_Placeholder);


        JBTN_Unselect6 = new JButton("-");
        JBTN_Unselect6.setFont(new Font("", Font.BOLD, 14));
        JBTN_Unselect6.setPreferredSize(new Dimension(20, 20));
        JBTN_Unselect6.setMargin(new Insets(0, 0, 1, 1));
        JBTN_Unselect6.setFocusable(false);
        PNL_Component.add(JBTN_Unselect6);


        JBTN_Select6 = new JButton("+");
        JBTN_Select6.setFont(new Font("", Font.BOLD, 14));
        JBTN_Select6.setPreferredSize(new Dimension(20, 20));
        JBTN_Select6.setMargin(new Insets(0, 0, 1, 0));
        JBTN_Select6.addActionListener(CL);
        JBTN_Select6.setFocusable(false);
        PNL_Component.add(JBTN_Select6);


        JLBL_Type = new JLabel("Type");
        PNL_Component.add(JLBL_Type);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Type = new JLabel(typeOphalen(7, con));
        JLBL_I_Type.setBorder(border1);
        JLBL_I_Type.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Type);

        SEPA_Top = new JSeparator();
        SEPA_Top.setPreferredSize(new Dimension(190, 1));
        SEPA_Top.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Top);

        JLBL_Beschikbaarheid = new JLabel("Beschikbaarheid");
        PNL_Component.add(JLBL_Beschikbaarheid);

        JLBL_Placeholder = new JLabel("     ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Beschikbaarheid = new JLabel(getgegevens(con, 7)[2]);
        JLBL_I_Beschikbaarheid.setBorder(border1);
        JLBL_I_Beschikbaarheid.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Beschikbaarheid);

        SEPA_Midt = new JSeparator();
        SEPA_Midt.setPreferredSize(new Dimension(190, 1));
        SEPA_Midt.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midt);

        JLBL_Prijs = new JLabel("Prijs");
        PNL_Component.add(JLBL_Prijs);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Prijs = new JLabel(getgegevens(con, 7)[3]);
        JLBL_I_Prijs.setBorder(border1);
        JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Prijs);

        SEPA_Midb = new JSeparator();
        SEPA_Midb.setPreferredSize(new Dimension(190, 1));
        SEPA_Midb.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midb);

        JLBL_Processorb = new JLabel("Processorbelasting ");
        PNL_Component.add(JLBL_Processorb);

        JLBL_I_Proccesb = new JLabel();
        JLBL_I_Proccesb.setBorder(border1);
        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Proccesb);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
        PNL_Component.add(JLBL_Diskruimte);

        JLBL_Placeholder = new JLabel("");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Diskruimte = new JLabel();
        JLBL_I_Diskruimte.setBorder(border1);
        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Diskruimte);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_NetworkLoad = new JLabel("Networkload");
        PNL_Component.add(JLBL_NetworkLoad);

        JLBL_Placeholder = new JLabel("             ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_NetworkLoad = new JLabel();
        JLBL_I_NetworkLoad.setBorder(border1);
        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_NetworkLoad);
    }

    public String[] getgegevens(Connection con, int ID) throws SQLException {
        String[] gegevens = new String[9];
        try {
            pstmt = con.prepareStatement("Select * FROM component WHERE componentID=?;");
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                gegevens[0] = Integer.toString(rs.getInt("componentID"));
                gegevens[1] = Integer.toString(rs.getInt("apparaatID"));
                gegevens[2] = rs.getString("beschikbaarheidspercentage");
                gegevens[3] = "€ " + Integer.toString(rs.getInt("prijs"));
                gegevens[4] = rs.getString("ipadres");
                gegevens[5] = typeOphalen(ID, con);
                gegevens[6] = naamOphalen(ID, con);

                String[] cpudisk = GegevensOphalen.start(gegevens[4]);
                gegevens[7] = cpudisk[0];
                gegevens[8] = cpudisk[1];

            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt !=
                    null) {
                pstmt.close();
            }
        }
        return gegevens;
    }

    public String typeOphalen(int apparaatID, Connection con) throws SQLException {
        String string = "";
        try {
            pstmt = con.prepareStatement("Select * FROM firewall WHERE apparaatID=?;");
            pstmt.setInt(1, apparaatID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                string = rs.getString("rol");
            }
            rs.close();

            pstmt = con.prepareStatement("Select * FROM DBserver WHERE apparaatID=?;");
            pstmt.setInt(1, apparaatID);
            ResultSet rs2 = pstmt.executeQuery();
            if (rs2.next()) {
                string = rs2.getString("rol");
            }
            rs2.close();

            pstmt = con.prepareStatement("Select * FROM webserver WHERE apparaatID=?;");
            pstmt.setInt(1, apparaatID);
            ResultSet rs3 = pstmt.executeQuery();
            if (rs3.next()) {
                string = rs3.getString("rol");
            }
            rs3.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt !=
                    null) {
                pstmt.close();
            }
        }

        return string;
    }

    public String naamOphalen(int apparaatID, Connection con) throws SQLException {
        String string = "";
        try {
            pstmt = con.prepareStatement("Select * FROM hardware WHERE apparaatID=?;");
            pstmt.setInt(1, apparaatID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                string = rs.getString("type");
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt !=
                    null) {
                pstmt.close();
            }
        }

        return string;

    }
}

/*
 public void AddComponent() throws SQLException {
        key++;

        PNL_Component = new JPanel();
        PNL_Component.setLayout(new BoxLayout(PNL_Component, BoxLayout.Y_AXIS));
        PNL_Component.setPreferredSize(new Dimension(200, 185));
        PNL_Component.setBackground(Color.lightGray);
        PNL_Component.setLayout(new FlowLayout());
        add(PNL_Component);

        JLBL_Naam = new JLabel((naamOphalen(key, con)));
        JLBL_Naam.setBorder(border2);
        JLBL_Naam.setPreferredSize(new Dimension(130, 20));
        JLBL_Naam.setHorizontalAlignment(SwingConstants.CENTER);
        PNL_Component.add(JLBL_Naam);

        JLBL_Placeholder = new JLabel("  ");
        PNL_Component.add(JLBL_Placeholder);

       Component_Buttons();

        JLBL_Type = new JLabel("Type");
        PNL_Component.add(JLBL_Type);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Type = new JLabel(typeOphalen(key, con));
        JLBL_I_Type.setBorder(border1);
        JLBL_I_Type.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Type);

        SEPA_Top = new JSeparator();
        SEPA_Top.setPreferredSize(new Dimension(190, 1));
        SEPA_Top.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Top);

        JLBL_Beschikbaarheid = new JLabel("Beschikbaarheid");
        PNL_Component.add(JLBL_Beschikbaarheid);

        JLBL_Placeholder = new JLabel("     ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Beschikbaarheid = new JLabel(getgegevens(con, key)[2]);
        JLBL_I_Beschikbaarheid.setBorder(border1);
        JLBL_I_Beschikbaarheid.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Beschikbaarheid);

        SEPA_Midt = new JSeparator();
        SEPA_Midt.setPreferredSize(new Dimension(190, 1));
        SEPA_Midt.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midt);

        JLBL_Prijs = new JLabel("Prijs");
        PNL_Component.add(JLBL_Prijs);

        JLBL_Placeholder = new JLabel("                            ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Prijs = new JLabel(getgegevens(con, key)[3]);
        JLBL_I_Prijs.setBorder(border1);
        JLBL_I_Prijs.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Prijs);

        SEPA_Midb = new JSeparator();
        SEPA_Midb.setPreferredSize(new Dimension(190, 1));
        SEPA_Midb.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Midb);

        JLBL_Processorb = new JLabel("Processorbelasting ");
        PNL_Component.add(JLBL_Processorb);

        JLBL_I_Proccesb = new JLabel();
        JLBL_I_Proccesb.setBorder(border1);
        JLBL_I_Proccesb.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Proccesb);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_Diskruimte = new JLabel("Beschikbare ruimte");
        PNL_Component.add(JLBL_Diskruimte);

        JLBL_Placeholder = new JLabel("");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_Diskruimte = new JLabel();
        JLBL_I_Diskruimte.setBorder(border1);
        JLBL_I_Diskruimte.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_Diskruimte);

        SEPA_Bottom = new JSeparator();
        SEPA_Bottom.setPreferredSize(new Dimension(190, 1));
        SEPA_Bottom.setForeground(Color.darkGray);
        PNL_Component.add(SEPA_Bottom);

        JLBL_NetworkLoad = new JLabel("Networkload");
        PNL_Component.add(JLBL_NetworkLoad);

        JLBL_Placeholder = new JLabel("             ");
        PNL_Component.add(JLBL_Placeholder);

        JLBL_I_NetworkLoad = new JLabel();
        JLBL_I_NetworkLoad.setBorder(border1);
        JLBL_I_NetworkLoad.setPreferredSize(new Dimension(70, 15));
        PNL_Component.add(JLBL_I_NetworkLoad);
    }

    public void Component_Buttons() {
        index++;
        String naam = Integer.toString(index);
        JBTN_Select = new JButton("-");
        JBTN_Unselect = new JButton("-");
        JBTN_Unselect.setFont(new Font("", Font.BOLD, 14));
        JBTN_Unselect.setPreferredSize(new Dimension(20, 20));
        JBTN_Unselect.setMargin(new Insets(0, 0, 1, 1));
        JBTN_Unselect.setFocusable(false);
        JBTN_Select.setName(naam);
        PNL_Component.add(JBTN_Unselect);

        JBTN_Select = new JButton("+");
        JBTN_Select.setFont(new Font(naam, Font.BOLD, 14));
        JBTN_Select.setPreferredSize(new Dimension(20, 20));
        JBTN_Select.setMargin(new Insets(0, 0, 1, 0));
        JBTN_Select.addActionListener(this);
        JBTN_Select.setFocusable(false);
        PNL_Component.add(JBTN_Select);
    }
 */