package view;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import controller.Controller;
import controller.CronusController;
import model.Course;
import model.Student;
import model.Studied;
import model.Studying;

import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;

import javax.swing.JTextArea;

public class StartView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8194750818540449165L;
	private JPanel contentPane;
	private JTextField text_cCodeS;
	private JTextField text_cNameS;
	private JTextField text_cPointsS;
	private JTextField text_cCode;
	private JTextField text_cName;
	private JTextField text_cPoints;
	private JTextField text_sPnrS;
	private JTextField text_sNameS;
	private JTextField text_AddressS;
	private JTextField text_sPnr;
	private JTextField text_sName;
	private JTextField text_Address;
	private JTextField text_finishPnr;
	private JTextField text_finishCode;
	private JTextField text_startcourseSpnr;
	private JTextField text_startcourseCcode;
	private JTextField text_cCodeStudent;
	private JTextField dialogruta;
	private JTable studentTable;
	private JTable courseTable;
	private JTable searchTable;
	private JTable cronusTable;
	DefaultTableModel dtmStudent;
	private JTextField messageTime;
	private JTextField messageTimeBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartView frame = new StartView();
					frame.setVisible(true);
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 110, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DefaultTableModel dtmCronus = new DefaultTableModel();

		String[] colName = { "Studentnamn", "Personnummer", "Adress" };
		DefaultTableModel dtmStudent = new DefaultTableModel(colName, 0);

		String[] courseName = { "Kursnamn", "Kurskod", "HP" };
		DefaultTableModel dtmCourse = new DefaultTableModel(courseName, 0);

		String[] searchcolum = { "Personnummer", "Kurskod", "Termin", "Betyg" };
		DefaultTableModel dtmSearch = new DefaultTableModel(searchcolum, 0);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(6, 6, 426, 476);
		contentPane.add(tabbedPane_1);

		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane_1.addTab("Skapa", null, layeredPane, null);

		text_cCode = new JTextField();
		text_cCode.setColumns(10);
		text_cCode.setBounds(146, 34, 134, 28);
		layeredPane.add(text_cCode);

		text_cName = new JTextField();
		text_cName.setColumns(10);
		text_cName.setBounds(146, 62, 134, 28);
		layeredPane.add(text_cName);

		text_cPoints = new JTextField();
		text_cPoints.setColumns(10);
		text_cPoints.setBounds(146, 90, 134, 28);
		layeredPane.add(text_cPoints);

		JLabel label_4 = new JLabel("HP");
		label_4.setBounds(72, 96, 61, 16);
		layeredPane.add(label_4);

		JLabel label_5 = new JLabel("Kursnamn");
		label_5.setBounds(72, 68, 73, 16);
		layeredPane.add(label_5);

		JLabel label_6 = new JLabel("Kurskod");
		label_6.setBounds(72, 40, 61, 16);
		layeredPane.add(label_6);

		JLabel label_7 = new JLabel("Kurs");
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_7.setBounds(184, 6, 61, 16);
		layeredPane.add(label_7);

		JButton btnRegCourse = new JButton("Skapa");
		btnRegCourse.setBounds(157, 130, 117, 29);
		layeredPane.add(btnRegCourse);

		JLabel label_12 = new JLabel("Personnr");
		label_12.setBounds(72, 220, 61, 16);
		layeredPane.add(label_12);

		text_sPnr = new JTextField();
		text_sPnr.setColumns(10);
		text_sPnr.setBounds(145, 214, 134, 28);
		layeredPane.add(text_sPnr);

		text_sName = new JTextField();
		text_sName.setColumns(10);
		text_sName.setBounds(145, 242, 134, 28);
		layeredPane.add(text_sName);

		JLabel label_13 = new JLabel("Namn");
		label_13.setBounds(72, 248, 73, 16);
		layeredPane.add(label_13);

		JLabel label_14 = new JLabel("Adress");
		label_14.setBounds(72, 276, 61, 16);
		layeredPane.add(label_14);

		text_Address = new JTextField();
		text_Address.setColumns(10);
		text_Address.setBounds(145, 270, 134, 28);
		layeredPane.add(text_Address);

		JLabel label_15 = new JLabel("Student");
		label_15.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_15.setBounds(183, 184, 61, 16);
		layeredPane.add(label_15);

		JButton btnRegStudent = new JButton("Skapa");
		btnRegStudent.setBounds(156, 310, 117, 29);
		layeredPane.add(btnRegStudent);
		btnRegStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					long startTime = System.currentTimeMillis();
					if (text_sName.getText().isEmpty()
							|| text_sPnr.getText().isEmpty()) {
						dialogruta.setText("Kunde inte skapa student");
					} else {
						boolean success = Controller.createStudent(
								text_sName.getText(), text_Address.getText(),
								text_sPnr.getText().toUpperCase());
						String message;

						if (success) {
							long estimatedTime = System.currentTimeMillis()
									- startTime;
							String time = Long.toString(estimatedTime);
							messageTime.setText(time + "ms");
							message = "Du har nu registrerat en student";
						} else {
							message = "Studenten finns redan registerad";
						}
						dialogruta.setText(message);

						text_sName.setText("");
						text_Address.setText("");
						text_sPnr.setText("");
						updateStudentTable();
					}
				} catch (Exception msgs) {
					dialogruta.setText("OBS, Något gick fel! Försök igen!");
				}

			}
		});
		btnRegCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					long startTime = System.currentTimeMillis();

					int a = Integer.parseInt(text_cPoints.getText());

					if (text_cCode.getText().isEmpty()
							|| text_cName.getText().isEmpty()
							|| text_cPoints.getText().isEmpty()) {
						dialogruta
								.setText("Du kunde tyvärr inte lägga till kurs");
					} else {
						boolean success = Controller.createCourse(text_cName
								.getText(), text_cCode.getText().toUpperCase(),
								a);
						if (success) {

							long estimatedTime = System.currentTimeMillis()
									- startTime;
							String time = Long.toString(estimatedTime);
							messageTime.setText(time + "ms");
							dialogruta.setText("Du har nu skapat en kurs");

							updateCourseTable();

						} else {
							dialogruta.setText("Kurs finns redan inlagd");
						}

					}

				} catch (Exception msgs) {
					dialogruta.setText("Du kunde tyvärr inte lägga till kurs");
				}
			}
		});

		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane_1.addTab("Sök/radera", null, layeredPane_1, null);

		JLabel text_Precentage = new JLabel("");
		text_Precentage.setBounds(156, 124, 49, 16);
		layeredPane_1.add(text_Precentage);

		text_cCodeS = new JTextField();
		text_cCodeS.setColumns(10);
		text_cCodeS.setBounds(146, 34, 134, 28);
		layeredPane_1.add(text_cCodeS);

		JCheckBox chckbxHarLst = new JCheckBox("Avslutade");
		chckbxHarLst.setBounds(235, 124, 128, 23);
		layeredPane_1.add(chckbxHarLst);

		text_cNameS = new JTextField();
		text_cNameS.setEditable(false);
		text_cNameS.setColumns(10);
		text_cNameS.setBounds(146, 62, 134, 28);
		layeredPane_1.add(text_cNameS);

		text_cPointsS = new JTextField();
		text_cPointsS.setEditable(false);
		text_cPointsS.setColumns(10);
		text_cPointsS.setBounds(146, 90, 134, 28);
		layeredPane_1.add(text_cPointsS);

		JLabel label = new JLabel("HP");
		label.setBounds(72, 96, 61, 16);
		layeredPane_1.add(label);

		JLabel label_1 = new JLabel("Kursnamn");
		label_1.setBounds(72, 68, 73, 16);
		layeredPane_1.add(label_1);

		JLabel label_2 = new JLabel("Kurskod");
		label_2.setBounds(72, 40, 61, 16);
		layeredPane_1.add(label_2);

		JLabel label_3 = new JLabel("Kurs");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_3.setBounds(183, 6, 61, 16);
		layeredPane_1.add(label_3);

		JButton btn_courseSearch = new JButton("Sök");
		btn_courseSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (chckbxHarLst.isSelected()) {
						long startTime = System.currentTimeMillis();

						Course c = Controller.getCourse(text_cCodeS.getText()
								.toUpperCase());
						String precentage = new String();
						if (text_cCodeS.getText().toLowerCase()
								.equals(c.getcCode().toLowerCase())) {
							text_cNameS.setText(c.getcName());
							text_cPointsS.setText((String.valueOf(c
									.getcPoints())));
							dialogruta.setText("Du hittade en kurs");
							updateSearchTableToStudiedcCode(c.getcCode());

							precentage = Controller.getPrecentageinCourse(c
									.getcCode());
							text_Precentage.setText(precentage + " %");

						} else {
							dialogruta
									.setText("Fanns ingen Kurs med den kurskoden");
							text_cNameS.setText("");
							text_cPointsS.setText("");
							long estimatedTime = System.currentTimeMillis()
									- startTime;
							String time = Long.toString(estimatedTime);
							messageTime.setText(time + "ms");
						}

					} else {
						long startTime = System.currentTimeMillis();

						Course c = Controller.getCourse(text_cCodeS.getText()
								.toUpperCase());
						String precentage = new String();
						if (text_cCodeS.getText().toLowerCase()
								.equals(c.getcCode().toLowerCase())) {
							text_cNameS.setText(c.getcName());
							text_cPointsS.setText((String.valueOf(c
									.getcPoints())));
							dialogruta.setText("Du hittade en kurs");
							updateSearchTableToStudyingCcode(c.getcCode());

							precentage = Controller.getPrecentageinCourse(c
									.getcCode());
							text_Precentage.setText(precentage + " %");
							long estimatedTime = System.currentTimeMillis()
									- startTime;
							String time = Long.toString(estimatedTime);
							messageTime.setText(time + "ms");

						} else {
							dialogruta
									.setText("Fanns ingen Kurs med den kurskoden");
							text_cNameS.setText("");
							text_cPointsS.setText("");
						}

					}

				} catch (Exception msg) {
					dialogruta.setText("Något gick fel");
				}
			}

		});
		btn_courseSearch.setBounds(235, 148, 117, 29);
		layeredPane_1.add(btn_courseSearch);

		JLabel label_8 = new JLabel("Personnr");
		label_8.setBounds(72, 220, 61, 16);
		layeredPane_1.add(label_8);

		text_sPnrS = new JTextField();
		text_sPnrS.setColumns(10);
		text_sPnrS.setBounds(145, 214, 134, 28);
		layeredPane_1.add(text_sPnrS);

		text_sNameS = new JTextField();
		text_sNameS.setEditable(false);
		text_sNameS.setColumns(10);
		text_sNameS.setBounds(145, 242, 134, 28);
		layeredPane_1.add(text_sNameS);

		JLabel label_9 = new JLabel("Namn");
		label_9.setBounds(72, 248, 73, 16);
		layeredPane_1.add(label_9);

		JLabel label_10 = new JLabel("Adress");
		label_10.setBounds(72, 276, 61, 16);
		layeredPane_1.add(label_10);

		text_AddressS = new JTextField();
		text_AddressS.setEditable(false);
		text_AddressS.setColumns(10);
		text_AddressS.setBounds(145, 270, 134, 28);
		layeredPane_1.add(text_AddressS);

		JLabel label_11 = new JLabel("Student");
		label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_11.setBounds(183, 184, 61, 16);
		layeredPane_1.add(label_11);

		JButton button = new JButton("Radera");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.currentTimeMillis();
				try {

					Controller.deleteCourse(text_cCodeS.getText());
					updateCourseTable();
					updateSearchTableToStudied();
					updateSearchTableToStudying();
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTime.setText(time + "ms");
					dialogruta.setText("Raderade kurs");
				} catch (Exception msg) {
					dialogruta.setText("Kunde inte radera kurs");
				}
			}
		});
		button.setBounds(54, 148, 117, 29);
		layeredPane_1.add(button);

		JButton button_1 = new JButton("Radera");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.currentTimeMillis();
				try {

					Controller.deleteStudent(text_sPnrS.getText());
					text_sNameS.setText("");
					text_AddressS.setText("");
					text_sPnrS.setText("");
					updateStudentTable();
					updateSearchTableToStudying();

					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTime.setText(time + "ms");
					dialogruta.setText("Raderade student");
				} catch (Exception msg) {
					dialogruta.setText("Kunde inte radera Student");
				}
			}
		});
		button_1.setBounds(54, 349, 117, 29);
		layeredPane_1.add(button_1);
		text_cCodeS.setText("");
		JButton btnStudentSearch = new JButton("Sök");
		btnStudentSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.currentTimeMillis();

				try {
					Student st = new Student();
					st = Controller.getStudent(text_sPnrS.getText());

					if (text_sPnrS.getText().toUpperCase().equals(st.getsPnr())) {
						text_sNameS.setText(st.getsName());
						text_AddressS.setText(st.getAddress());
						dialogruta.setText("Du hittade en student");
						long estimatedTime = System.currentTimeMillis()
								- startTime;
						String time = Long.toString(estimatedTime);
						messageTime.setText(time + "ms");
					} else {
						dialogruta
								.setText("Finns ingen Student med personnummer "
										+ text_sPnrS.getText());
						text_sNameS.setText("");
						text_AddressS.setText("");
					}

					if (!text_cCodeStudent.getText().isEmpty()) {

						Studied s = Controller.getStudentStudied(
								text_sPnrS.getText(),
								text_cCodeStudent.getText());
						text_finishCode.setText(s.getcCode());
						text_finishPnr.setText(s.getsPnr());
						updateSearchTableToFitStudent(text_sPnrS.getText(),
								text_cCodeStudent.getText());
						long estimatedTime = System.currentTimeMillis()
								- startTime;
						String time = Long.toString(estimatedTime);
						messageTime.setText(time + "ms");

					}

				} catch (Exception msgs) {
					// msgs.printStackTrace();
					dialogruta.setText("OBS, Något gick fel!");
					text_sNameS.setText("");
					text_AddressS.setText("");

				}

			}
		});
		btnStudentSearch.setBounds(235, 349, 117, 29);
		layeredPane_1.add(btnStudentSearch);

		JLabel lblVidSkningAv = new JLabel(
				"Vid hämting av student på angiven kurs,");
		lblVidSkningAv.setBounds(75, 390, 263, 16);
		layeredPane_1.add(lblVidSkningAv);

		JLabel lblAngeKurskod = new JLabel("ange kurskod också");
		lblAngeKurskod.setBounds(152, 408, 127, 16);
		layeredPane_1.add(lblAngeKurskod);

		JLabel label_16 = new JLabel("Kurskod");
		label_16.setBounds(72, 310, 61, 16);
		layeredPane_1.add(label_16);

		text_cCodeStudent = new JTextField();
		text_cCodeStudent.setText((String) null);
		text_cCodeStudent.setColumns(10);
		text_cCodeStudent.setBounds(146, 304, 134, 28);
		layeredPane_1.add(text_cCodeStudent);

		JLabel lblProcentantal = new JLabel("Betyg A : ");
		lblProcentantal.setBounds(72, 124, 80, 16);
		layeredPane_1.add(lblProcentantal);

		JTabbedPane tabStudying = new JTabbedPane(JTabbedPane.TOP);
		tabStudying.setBounds(6, 477, 425, 295);
		contentPane.add(tabStudying);

		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabStudying.addTab("Påbörja kurs", null, layeredPane_2, null);

		JLabel label_22 = new JLabel("Registera student på vald kurs");
		label_22.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		label_22.setBounds(104, 6, 208, 16);
		layeredPane_2.add(label_22);

		JLabel lblStudentpnr = new JLabel("Studentpnr");
		lblStudentpnr.setBounds(41, 46, 85, 16);
		layeredPane_2.add(lblStudentpnr);

		text_startcourseSpnr = new JTextField();
		text_startcourseSpnr.setColumns(10);
		text_startcourseSpnr.setBounds(37, 73, 100, 28);
		layeredPane_2.add(text_startcourseSpnr);

		text_startcourseCcode = new JTextField();
		text_startcourseCcode.setColumns(10);
		text_startcourseCcode.setBounds(162, 73, 100, 28);
		layeredPane_2.add(text_startcourseCcode);

		JComboBox<String> comboBox_semester = new JComboBox<String>();

		layeredPane_2.add(comboBox_semester);

		comboBox_semester.setBounds(274, 75, 85, 27);
		comboBox_semester.addItem("HT15");
		comboBox_semester.addItem("VT16");
		comboBox_semester.addItem("HT16");
		comboBox_semester.addItem("VT17");
		comboBox_semester.addItem("VT18");

		JLabel lblKurskod = new JLabel("Kurskod");
		lblKurskod.setBounds(179, 46, 61, 16);
		layeredPane_2.add(lblKurskod);

		JButton btnRegisterStudentOnCourse = new JButton("Påbörja");
		btnRegisterStudentOnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.currentTimeMillis();

				try {

					if (Controller.getStudentStudiedAlready(
							text_startcourseSpnr.getText(),
							text_startcourseCcode.getText())) {
						dialogruta
								.setText("Studenten läser redan denna kursen");
						long estimatedTime = System.currentTimeMillis()
								- startTime;
						String time = Long.toString(estimatedTime);
						messageTime.setText(time + "ms");
						return;

					}
					String semester = comboBox_semester.getSelectedItem()
							.toString();

					Student s = Controller.getStudent(text_startcourseSpnr
							.getText());

					if (s.equals(null)) {
						dialogruta.setText("Obs, Något gick fel");
					} else {
						Course c = Controller.getCourse(text_startcourseCcode
								.getText());
						int coursePoints = c.getcPoints();
						int sumPoints = Controller.getStudentsCoursesPoints(
								text_startcourseSpnr.getText(), semester);
						if (sumPoints + coursePoints <= 45) {
							boolean success = Controller.createStudyingStudent(
									text_startcourseCcode.getText()
											.toUpperCase(),
									text_startcourseSpnr.getText()
											.toUpperCase(), semester);
							long estimatedTime = System.currentTimeMillis()
									- startTime;
							String time = Long.toString(estimatedTime);
							messageTime.setText(time + "ms");
							if (!success) {
								dialogruta
										.setText("Studenten läser redan denna kursen");
								estimatedTime = System.currentTimeMillis()
										- startTime;
								time = Long.toString(estimatedTime);
								messageTime.setText(time + "ms");
								return;
							}
							updateSearchTableToStudying();
							dialogruta
									.setText("Du har nu registerat en student till en kurs");
						} else {
							dialogruta.setText("Student kan endast läsa 45 hp");
							long estimatedTime = System.currentTimeMillis()
									- startTime;
							String time = Long.toString(estimatedTime);
							messageTime.setText(time + "ms");
						}
					}

				} catch (Exception msgs) {
					dialogruta.setText("OBS, Något gick fel!");
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTime.setText(time + "ms");
				}

			}

		});
		btnRegisterStudentOnCourse.setBounds(145, 146, 117, 29);
		layeredPane_2.add(btnRegisterStudentOnCourse);

		JLabel lblTermin = new JLabel("Termin");
		lblTermin.setBounds(282, 46, 61, 16);
		layeredPane_2.add(lblTermin);

		JLayeredPane pane_finishCourse = new JLayeredPane();
		tabStudying.addTab("Slutföra kurs", null, pane_finishCourse, null);
		pane_finishCourse.setLayout(null);

		JLabel lblSlutfrStudentP = new JLabel("Slutföra kurs med vald student");
		lblSlutfrStudentP.setBounds(105, 6, 214, 16);
		lblSlutfrStudentP.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		pane_finishCourse.add(lblSlutfrStudentP);

		JLabel label_19 = new JLabel("Betyg");
		label_19.setBounds(84, 128, 41, 16);
		pane_finishCourse.add(label_19);

		text_finishPnr = new JTextField();
		text_finishPnr.setBounds(37, 73, 100, 28);

		text_finishPnr.setColumns(10);
		pane_finishCourse.add(text_finishPnr);

		text_finishCode = new JTextField();
		text_finishCode.setBounds(162, 73, 100, 28);
		text_finishCode.setColumns(10);
		pane_finishCourse.add(text_finishCode);

		JComboBox<String> comboBoxGrade = new JComboBox<String>();
		comboBoxGrade.setBounds(72, 147, 61, 27);
		pane_finishCourse.add(comboBoxGrade);
		comboBoxGrade.addItem("A");
		comboBoxGrade.addItem("B");
		comboBoxGrade.addItem("C");
		comboBoxGrade.addItem("D");
		comboBoxGrade.addItem("E");
		comboBoxGrade.addItem("U");

		JButton btnSlutfra = new JButton("Slutföra");
		btnSlutfra.setBounds(162, 146, 93, 29);
		btnSlutfra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.currentTimeMillis();

				try {
					Studying st = Controller.getStudyingStudent(
							text_finishPnr.getText(), text_finishCode.getText());

					String grade = comboBoxGrade.getSelectedItem().toString();

					Controller.createStudiedStudent(grade, text_finishCode
							.getText().toUpperCase(), text_finishPnr.getText()
							.toUpperCase(), st.getSemester());

					Controller.deleteStudyingStudent(text_finishCode.getText(),
							text_finishPnr.getText());
					updateSearchTableToStudied();
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTime.setText(time + "ms");
					dialogruta.setText("Registerat Student och dess betyg");

				} catch (Exception msgs) {
					dialogruta.setText("OBS, Något gick fel!");
				}

			}
		});
		pane_finishCourse.add(btnSlutfra);

		JLabel lblKurskod_1 = new JLabel("Kurskod");
		lblKurskod_1.setBounds(175, 48, 61, 16);
		pane_finishCourse.add(lblKurskod_1);

		JLabel label_18 = new JLabel("Studentpnr");
		label_18.setBounds(37, 48, 85, 16);
		pane_finishCourse.add(label_18);

		JButton button_4 = new JButton("Avhopp");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.currentTimeMillis();

				try {
					Controller.deleteStudyingStudent(text_finishCode.getText(),
							text_finishPnr.getText());

					dialogruta
							.setText("Du har nu tagit bort en student från kursen");
					updateSearchTableToStudying();
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTime.setText(time + "ms");
					dialogruta.setText("Tagit bort student");
				} catch (Exception msg) {
					dialogruta.setText("Något gick fel");
				}
			}
		});
		button_4.setBounds(162, 187, 93, 29);
		pane_finishCourse.add(button_4);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(431, 6, 963, 766);
		contentPane.add(tabbedPane);

		JLayeredPane layeredPane_4 = new JLayeredPane();
		tabbedPane.addTab("Studenter/kurser", null, layeredPane_4, null);

		JScrollPane scrollPane_Student = new JScrollPane();

		scrollPane_Student.setEnabled(false);
		scrollPane_Student.setBounds(77, 34, 337, 346);
		layeredPane_4.add(scrollPane_Student);

		studentTable = new JTable(dtmStudent);
		studentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int sel = studentTable.getSelectedRow();
					String pnr = dtmStudent.getValueAt(sel, 1).toString();
					text_startcourseSpnr.setText(pnr);
					text_finishPnr.setText(pnr);

				} catch (Exception msg) {

				}
			}
		});
		scrollPane_Student.setViewportView(studentTable);
		JScrollPane scrollPane_Search = new JScrollPane();
		scrollPane_Search.setBounds(77, 393, 687, 292);
		layeredPane_4.add(scrollPane_Search);

		searchTable = new JTable(dtmSearch);
		scrollPane_Search.setViewportView(searchTable);

		JScrollPane scrollPane_Course = new JScrollPane();
		scrollPane_Course.setBounds(426, 35, 337, 345);
		layeredPane_4.add(scrollPane_Course);

		courseTable = new JTable(dtmCourse);
		scrollPane_Course.setViewportView(courseTable);
		courseTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int sel = courseTable.getSelectedRow();
					String cCode = dtmCourse.getValueAt(sel, 1).toString();
					text_startcourseCcode.setText(cCode);
					text_finishCode.setText(cCode);

				} catch (Exception msg) {

				}

			}
		});

		JLabel label_21 = new JLabel("Studenttabell");
		label_21.setBounds(191, 6, 100, 16);
		layeredPane_4.add(label_21);

		JLabel label_23 = new JLabel("Kurstabell");
		label_23.setBounds(551, 6, 100, 16);
		layeredPane_4.add(label_23);

		JButton button_2 = new JButton("Påbörjade kurser");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSearchTableToStudying();
			}
		});
		button_2.setBounds(776, 407, 160, 29);
		layeredPane_4.add(button_2);

		JButton button_3 = new JButton("Slutförda kurser");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSearchTableToStudied();
			}
		});
		button_3.setBounds(776, 448, 160, 29);
		layeredPane_4.add(button_3);

		dialogruta = new JTextField();
		dialogruta.setText("Dialogruta ");
		dialogruta.setEditable(false);
		dialogruta.setBounds(77, 691, 574, 23);
		layeredPane_4.add(dialogruta);

		JButton btnVisaGenomstrmning = new JButton("Genomströmning");
		btnVisaGenomstrmning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSearchTableToAvg();
			}
		});
		btnVisaGenomstrmning.setBounds(776, 489, 160, 29);
		layeredPane_4.add(btnVisaGenomstrmning);

		messageTime = new JTextField();
		messageTime.setText("tid");
		messageTime.setEditable(false);
		messageTime.setBounds(657, 691, 107, 23);
		layeredPane_4.add(messageTime);

		JLayeredPane layeredPane_3 = new JLayeredPane();
		tabbedPane.addTab("CronusDatabas", null, layeredPane_3, null);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(6, 6, 930, 708);
		layeredPane_3.add(tabbedPane_2);

		JLayeredPane layeredPane_6 = new JLayeredPane();
		tabbedPane_2.addTab("Intern", null, layeredPane_6, null);

		JScrollPane scrollPane_Cronus = new JScrollPane();
		scrollPane_Cronus.setBounds(6, 167, 897, 489);
		layeredPane_6.add(scrollPane_Cronus);

		cronusTable = new JTable();
		scrollPane_Cronus.setViewportView(cronusTable);

		JButton btnKeys = new JButton("Keys");
		btnKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				long startTime = System.currentTimeMillis();
				try {

					cronusTable
							.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					cronusTable.setModel(dtmCronus);
					dtmCronus.setRowCount(0);
					String[] dtmCtables = { "Column-Name", "Table-Name" };
					dtmCronus.setColumnIdentifiers(dtmCtables);

					String[][] ts = CronusController.getKeys();
					for (int i = 0; i < ts.length; i++) {
						dtmCronus.addRow(ts[i]);

					}
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTimeBox.setText(time + "ms");
				} catch (Exception msgs) {

				}
			}
		});
		btnKeys.setBounds(169, 75, 127, 29);
		layeredPane_6.add(btnKeys);

		JLabel lblVljTabell = new JLabel("Välj tabell");
		lblVljTabell.setBounds(425, 6, 75, 16);
		layeredPane_6.add(lblVljTabell);

		JButton btnIndex = new JButton("Indexes");
		btnIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				long startTime = System.currentTimeMillis();
				try {

					cronusTable.setModel(dtmCronus);
					dtmCronus.setRowCount(0);
					cronusTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					String[] dtmCtables = { "object_id", "name", "index_id",
							"type", "type_desc", "is_unique", "data_space_id",
							"ignore_dup_key", "is_primary_key",
							"is_unique_constraint", "fill_factor", "is_padded",
							"is_disable", "is_hypothetical", "allow_row_locks",
							"allow_page_locks", "has_filter",
							"filter_definition" };

					dtmCronus.setColumnIdentifiers(dtmCtables);
					String[][] ts = CronusController.getIndex();
					for (int i = 0; i < ts.length; i++) {

						dtmCronus.addRow(ts[i]);

					}
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTimeBox.setText(time + "ms");
				} catch (Exception msgs) {

				}
			}

		});
		btnIndex.setBounds(468, 75, 117, 29);
		layeredPane_6.add(btnIndex);

		JButton btnTable_Constraint = new JButton("TableConstraint");
		btnTable_Constraint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				long startTime = System.currentTimeMillis();

				try {

					cronusTable.setModel(dtmCronus);
					dtmCronus.setRowCount(0);
					cronusTable
							.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					String[] dtmCtables = { "CONSTRAINT_CATALOG",
							"CONSTRAINT_SCHEMA", "CONSTRAINT_NAME",
							"TABLE_CATALOG", "TABLE_SCHEMA", "TABLE_NAME",
							"CONSTRAINT_TYPE", "IS_DEFERRABLE",
							"INITIALLY_DEFERRED" };

					dtmCronus.setColumnIdentifiers(dtmCtables);

					String[][] ts = CronusController.getTableCons();
					for (int i = 0; i < ts.length; i++) {

						dtmCronus.addRow(ts[i]);

					}
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTimeBox.setText(time + "ms");
				} catch (Exception msgs) {

				}

			}
		});
		btnTable_Constraint.setBounds(169, 34, 131, 29);
		layeredPane_6.add(btnTable_Constraint);

		JButton btnTablesOne = new JButton("Tables(One)");
		btnTablesOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.currentTimeMillis();
				try {

					cronusTable
							.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					cronusTable.setModel(dtmCronus);
					dtmCronus.setRowCount(0);
					String[] dtmCtables = { "Name", "Table_Schema",
							"Table_name", "Table_type" };

					dtmCronus.setColumnIdentifiers(dtmCtables);

					String[][] ts = CronusController.getAllTablesOne();
					for (int i = 0; i < ts.length; i++) {

						dtmCronus.addRow(ts[i]);

						long estimatedTime = System.currentTimeMillis()
								- startTime;
						String time = Long.toString(estimatedTime);
						messageTimeBox.setText(time + "ms");

					}
				} catch (Exception msgs) {

				}

			}

		});
		btnTablesOne.setBounds(312, 34, 131, 29);
		layeredPane_6.add(btnTablesOne);

		JButton btnTablesTwo = new JButton("Tables(Two)");
		btnTablesTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				long startTime = System.currentTimeMillis();
				try {

					cronusTable
							.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					cronusTable.setModel(dtmCronus);
					dtmCronus.setRowCount(0);
					String[] dtmCtables = { "Name" };

					dtmCronus.setColumnIdentifiers(dtmCtables);

					String[][] ts = CronusController.getAllTablesTwo();
					for (int i = 0; i < ts.length; i++) {

						dtmCronus.addRow(ts[i]);

					}
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTimeBox.setText(time + "ms");
				} catch (Exception msgs) {

				}

			}
		});
		btnTablesTwo.setBounds(312, 75, 131, 29);
		layeredPane_6.add(btnTablesTwo);

		JButton btnEmployeeOne = new JButton("Employee(One)");
		btnEmployeeOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				long startTime = System.currentTimeMillis();
				try {

					cronusTable.setModel(dtmCronus);
					dtmCronus.setRowCount(0);

					cronusTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					String[] dtmCtables = { "TABLE_CATALOG", "TABLE_SCHEMA",
							"TABLE_NAME", "COLUMN_NAME", "ORDINAL_POSITION",
							"COLUMN_DEFAULT", "IS_NULLABLE", "DATUM_TYPE",
							"CHARACTER_MAXIMUMLENGHT", "CHARACTER_OCTETLENGHT",
							"NUMERIC_PRECISION", "NUMERIC_PRECISION_RADIX",
							"NUMERIC_SCALE", "DATETIME_PERCISION",
							"CHARACTER_SET_CATALOG", "CHARACTER_SET_SCHEMA",
							"CHARACTER_SET_NAME", "COLLATION_CATALOG",
							"COLLATION_SCHEMA", "COLLATION_NAME",
							"DOMAIN_CATALOG", "DOMAIN_SCHEMA", "DOMAIN_NAME" };

					dtmCronus.setColumnIdentifiers(dtmCtables);

					String[][] ts = CronusController.getEmployeeOne();
					for (int i = 0; i < ts.length; i++) {

						dtmCronus.addRow(ts[i]);

					}
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTimeBox.setText(time + "ms");

				} catch (Exception msgs) {

				}

			}
		});
		btnEmployeeOne.setBounds(597, 34, 131, 29);
		layeredPane_6.add(btnEmployeeOne);

		JButton btnEmployeeTwo = new JButton("Employee(Two)");
		btnEmployeeTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				long startTime = System.currentTimeMillis();
				try {

					cronusTable
							.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

					cronusTable.setModel(dtmCronus);
					dtmCronus.setRowCount(0);
					String[] dtmCtables = { "COLUMN_NAME" };

					dtmCronus.setColumnIdentifiers(dtmCtables);

					String[][] ts = CronusController.getEmployeeTwo();
					for (int i = 0; i < ts.length; i++) {

						dtmCronus.addRow(ts[i]);

					}
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTimeBox.setText(time + "ms");
				} catch (Exception msgs) {

				}

			}
		});
		btnEmployeeTwo.setBounds(597, 75, 131, 29);
		layeredPane_6.add(btnEmployeeTwo);

		JButton btnMostRow = new JButton("MostRows");
		btnMostRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				long startTime = System.currentTimeMillis();
				try {

					cronusTable
							.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					cronusTable.setModel(dtmCronus);
					dtmCronus.setRowCount(0);
					String[] dtmCtables = { "TableName", "RowCount" };

					dtmCronus.setColumnIdentifiers(dtmCtables);

					String[][] ts = CronusController.getTableMaxRows();
					for (int i = 0; i < ts.length; i++) {

						dtmCronus.addRow(ts[i]);

					}
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTimeBox.setText(time + "ms");
				} catch (Exception msgs) {

				}

			}
		});
		btnMostRow.setBounds(468, 34, 117, 29);
		layeredPane_6.add(btnMostRow);

		JComboBox<String> comboBoxEmployee = new JComboBox<String>();

		comboBoxEmployee.addItem("[CRONUS Sverige AB$Employee]");
		comboBoxEmployee.addItem("[CRONUS Sverige AB$Employee Absence] ");
		comboBoxEmployee.addItem("[CRONUS Sverige AB$Employee Portal Setup] ");
		comboBoxEmployee.addItem("[CRONUS Sverige AB$Employee Qualification] ");
		comboBoxEmployee.addItem("[CRONUS Sverige AB$Employee Relative] ");
		comboBoxEmployee
				.addItem("[CRONUS Sverige AB$Employee Statistics Group]");
		comboBoxEmployee.addItem("[CRONUS Sverige AB$Employment Contract]");

		comboBoxEmployee.setBounds(169, 133, 416, 27);
		layeredPane_6.add(comboBoxEmployee);

		JButton btnSelect = new JButton("Välj");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				long startTime = System.currentTimeMillis();
				try {

					String choice = comboBoxEmployee.getSelectedItem()
							.toString();

					if (choice.equals("[CRONUS Sverige AB$Employee Absence]")) {

						String[] dtmCtables = { "timestamp", "Entry No_",
								"Employee No_", "From Date", "To Date" };

						dtmCronus.setColumnIdentifiers(dtmCtables);
					} else if (choice
							.equals("[CRONUS Sverige AB$Employee Portal Setup] ")) {

						String[] dtmCtables = { "timestamp", "Primary Key",
								"Search Limit", "Temp_ Key Index",
								"Temp_Table No" };

						dtmCronus.setColumnIdentifiers(dtmCtables);
					} else if (choice.equals("[CRONUS Sverige AB$Employee] ")) {

						String[] dtmCtables = { "timestamp", "No_",
								"First Name", "Last Name", "Initials" };

						dtmCronus.setColumnIdentifiers(dtmCtables);
					} else if (choice
							.equals("[CRONUS Sverige AB$Employee Qualification] ")) {

						String[] dtmCtables = { "timestamp", "Employee No_",
								"Line No_", "Qualification Code", "From Date" };

						dtmCronus.setColumnIdentifiers(dtmCtables);
					} else if (choice
							.equals("[CRONUS Sverige AB$Employee Relative] ")) {

						String[] dtmCtables = { "timestamp", "Employee No_",
								"Line No_", "Relative Code", "First Name" };

						dtmCronus.setColumnIdentifiers(dtmCtables);
					} else if (choice
							.equals("[CRONUS Sverige AB$Employee Statistics Group]")) {

						String[] dtmCtables = { "timestamp", "Code",
								"Description" };

						dtmCronus.setColumnIdentifiers(dtmCtables);
					} else if (choice
							.equals("[CRONUS Sverige AB$Employment Contract]")) {

						String[] dtmCtables = { "timestamp", "Code",
								"Description" };

						dtmCronus.setColumnIdentifiers(dtmCtables);
					}

					cronusTable
							.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					cronusTable.setModel(dtmCronus);
					dtmCronus.setRowCount(0);

					String[][] list = CronusController.getMetaData(choice);

					for (int i = 0; i < list.length; i++) {
						dtmCronus.addRow(list[i]);

					}
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTimeBox.setText(time + "ms");

				} catch (Exception msgs) {
					msgs.printStackTrace();
				}

			}
		});
		btnSelect.setBounds(597, 132, 131, 29);
		layeredPane_6.add(btnSelect);

		messageTimeBox = new JTextField();
		messageTimeBox.setText("tid");
		messageTimeBox.setBounds(841, 33, 50, 28);
		layeredPane_6.add(messageTimeBox);
		messageTimeBox.setColumns(10);

		JLayeredPane layeredPane_5 = new JLayeredPane();
		tabbedPane_2.addTab("Extern", null, layeredPane_5, null);

		JButton btnExcel = new JButton("Excel");
		btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop();
				long startTime=System.currentTimeMillis();
				try {
					desktop.open(new File(
							"/Users/Vojb/Documents/Systemvetenskap/Sysa13/Java/termin3/School/src/DB-Uppgift3Cronus.xlsx"));
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTimeBox.setText(time + "ms");
					
				} catch (Exception msg) {
					msg.printStackTrace();
				}
			}
		});
		btnExcel.setBounds(253, 79, 131, 29);
		layeredPane_5.add(btnExcel);

		JComboBox<String> comboBox_Forms = new JComboBox<String>();
		comboBox_Forms.addItem("Alla kunder");
		comboBox_Forms.addItem("Alla anställda");
		comboBox_Forms.setBounds(367, 148, 176, 27);
		layeredPane_5.add(comboBox_Forms);

		System.out.println();
		JTextArea textArea = new JTextArea();
		textArea.setBounds(80, 181, 1, 16);
		layeredPane_5.add(textArea);

		JLabel lblNewLabel = new JLabel("Öppna forms");
		lblNewLabel.setBounds(413, 120, 97, 16);
		layeredPane_5.add(lblNewLabel);

		JButton btnSql = new JButton("SQL(txt-fil)");
		btnSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Desktop desktop = Desktop.getDesktop();

				long startTime=System.currentTimeMillis();
				try {
					desktop.open(new File(
							"/Users/Vojb/Documents/Systemvetenskap/Sysa13/Java/termin3/School/src/SQLSatser.txt"));
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTimeBox.setText(time + "ms");
				} catch (Exception msg) {

				}

			}
		});
		btnSql.setBounds(396, 79, 131, 29);
		layeredPane_5.add(btnSql);

		JButton btnNewButton_1 = new JButton("Word");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop();

				long startTime=System.currentTimeMillis();
				try {
					desktop.open(new File(
							"/Users/Vojb/Documents/Systemvetenskap/Sysa13/Java/termin3/School/src/SQLSatser.docx"));
					long estimatedTime = System.currentTimeMillis() - startTime;
					String time = Long.toString(estimatedTime);
					messageTimeBox.setText(time + "ms");
				} catch (Exception msg) {

				}

			}
		});
		btnNewButton_1.setBounds(539, 79, 131, 29);
		layeredPane_5.add(btnNewButton_1);

		JLabel lblSqlSatser = new JLabel("SQL Satser");
		lblSqlSatser.setBounds(427, 33, 100, 16);
		layeredPane_5.add(lblSqlSatser);

		JButton btnFormsExcel = new JButton("Excel");
		btnFormsExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop();
				long startTime =System.currentTimeMillis();
				try {
					
					String choiceOne = comboBox_Forms.getSelectedItem()
							.toString();
					if (choiceOne.equals("Alla kunder")) {
						desktop.open(new File(
								"/Users/Vojb/Documents/Systemvetenskap/Sysa13/Java/termin3/School/src/Kunder.xlsx"));
						long estimatedTime = System.currentTimeMillis() - startTime;
						String time = Long.toString(estimatedTime);
						messageTimeBox.setText(time + "ms");
					} else {
						desktop.open(new File(
								"/Users/Vojb/Documents/Systemvetenskap/Sysa13/Java/termin3/School/src/Anställda.xlsx"));
						long estimatedTime = System.currentTimeMillis() - startTime;
						String time = Long.toString(estimatedTime);
						messageTimeBox.setText(time + "ms");
					}
				} catch (Exception msg) {

				}

			}

		});
		btnFormsExcel.setBounds(253, 187, 131, 29);
		layeredPane_5.add(btnFormsExcel);

		JButton btnFormsWord = new JButton("Word");
		btnFormsWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop();
				long startTime =System.currentTimeMillis();
				try {

					String choiceOne = comboBox_Forms.getSelectedItem()
							.toString();
					if (choiceOne.equals("Alla kunder")) {
						desktop.open(new File(
								"/Users/Vojb/Documents/Systemvetenskap/Sysa13/Java/termin3/School/src/Kunder.docx"));
						long estimatedTime = System.currentTimeMillis() - startTime;
						String time = Long.toString(estimatedTime);
						messageTimeBox.setText(time + "ms");
					} else {
						desktop.open(new File(
								"/Users/Vojb/Documents/Systemvetenskap/Sysa13/Java/termin3/School/src/Anställda.docx"));
						long estimatedTime = System.currentTimeMillis() - startTime;
						String time = Long.toString(estimatedTime);
						messageTimeBox.setText(time + "ms");
					}
				} catch (Exception msg) {

				}
			}
		});
		btnFormsWord.setBounds(539, 187, 131, 29);
		layeredPane_5.add(btnFormsWord);

		ArrayList<Student> students = Controller.getAllStudents();

		for (int i = 0; i < students.size(); i++) {
			String sName = students.get(i).getsName().toUpperCase();
			String sPnr = students.get(i).getsPnr();
			String Address = students.get(i).getAddress().toUpperCase();

			Object[] sData = { sPnr, sName, Address };

			dtmStudent.addRow(sData);

		}
		ArrayList<Course> courses = Controller.getAllCourses();

		for (int i = 0; i < courses.size(); i++) {
			String cName = courses.get(i).getcName();
			String cCode = courses.get(i).getcCode().toUpperCase();
			int cPoints = courses.get(i).getcPoints();

			Object[] cData = { cName, cCode, cPoints };

			dtmCourse.addRow(cData);

		}
		ArrayList<Studied> studies = Controller.getAllStudentsStudied();

		for (int i = 0; i < studies.size(); i++) {
			String grade = studies.get(i).getGrade().toUpperCase();
			String sPnr = studies.get(i).getsPnr().toUpperCase();
			String cCode = studies.get(i).getcCode().toUpperCase();
			String semester = studies.get(i).getSemester().toUpperCase();

			Object[] searchData = { sPnr, cCode, semester, grade };

			dtmSearch.addRow(searchData);

		}

	}

	public void updateCourseTable() {
		DefaultTableModel dtmCourse = new DefaultTableModel();
		String[] courseN = { "Kursnamn", "Kurskod", "HP" };
		dtmCourse.setColumnIdentifiers(courseN);

		ArrayList<Course> coursess = Controller.getAllCourses();

		for (int i = 0; i < coursess.size(); i++) {
			String cName = coursess.get(i).getcName();
			String cCode = coursess.get(i).getcCode().toUpperCase();
			int cPoints = coursess.get(i).getcPoints();

			Object[] cData = { cName, cCode, cPoints };

			dtmCourse.addRow(cData);

		}
		courseTable.setModel(dtmCourse);

	}

	public void updateStudentTable() {
		dtmStudent = new DefaultTableModel();
		String[] studentss = { "Studentnamn", "Personnummer", "Adress" };
		dtmStudent.setColumnIdentifiers(studentss);

		ArrayList<Student> updatestudents = Controller.getAllStudents();

		for (int i = 0; i < updatestudents.size(); i++) {
			String sName = updatestudents.get(i).getsName().toUpperCase();
			String sPnr = updatestudents.get(i).getsPnr();
			String Address = updatestudents.get(i).getAddress().toUpperCase();

			Object[] sData = { sPnr, sName, Address };

			dtmStudent.addRow(sData);

		}
		studentTable.setModel(dtmStudent);

	}

	private void updateSearchTableToStudying() {

		DefaultTableModel dtmSearch = new DefaultTableModel();
		String[] studies = { "Personnummer", "Kurskod", "Termin" };
		dtmSearch.setColumnIdentifiers(studies);

		ArrayList<Studying> updatestudying = Controller
				.getAllStudyingStudents();

		for (int i = 0; i < updatestudying.size(); i++) {
			String sPnr = updatestudying.get(i).getsPnr().toUpperCase();
			String cCode = updatestudying.get(i).getcCode().toUpperCase();
			String semester = updatestudying.get(i).getSemester().toUpperCase();

			Object[] searchData = { sPnr, cCode, semester };

			dtmSearch.addRow(searchData);

		}
		searchTable.setModel(dtmSearch);

	}

	private void updateSearchTableToStudiedcCode(String cCode) {
		DefaultTableModel dtmSearch = new DefaultTableModel();
		String[] studied = { "Personnummer", "Kurskod", "Termin", "Grade" };
		dtmSearch.setColumnIdentifiers(studied);

		ArrayList<Studied> updatestudied = Controller.showGradeCourse(cCode);

		for (int i = 0; i < updatestudied.size(); i++) {
			String grade = updatestudied.get(i).getGrade().toUpperCase();
			String cCodes = updatestudied.get(i).getcCode().toUpperCase();
			String semester = updatestudied.get(i).getSemester().toUpperCase();
			String sPnr = updatestudied.get(i).getsPnr().toUpperCase();

			Object[] searchData = { grade, cCodes, semester, sPnr };

			dtmSearch.addRow(searchData);

		}
		searchTable.setModel(dtmSearch);

	}

	private void updateSearchTableToStudied() {

		DefaultTableModel dtmSearch = new DefaultTableModel();
		String[] studied = { "Personnummer", "Kurskod", "Termin", "Betyg" };
		dtmSearch.setColumnIdentifiers(studied);

		ArrayList<Studied> updatestudied = Controller.getAllStudentsStudied();

		for (int i = 0; i < updatestudied.size(); i++) {
			String sPnr = updatestudied.get(i).getsPnr().toUpperCase();
			String cCode = updatestudied.get(i).getcCode().toUpperCase();
			String semester = updatestudied.get(i).getSemester().toUpperCase();
			String grade = updatestudied.get(i).getGrade().toUpperCase();

			Object[] searchData = { sPnr, cCode, semester, grade };

			dtmSearch.addRow(searchData);

		}
		searchTable.setModel(dtmSearch);

	}

	private void updateSearchTableToAvg() {
		DefaultTableModel dtmSearch = new DefaultTableModel();
		String[] studying = { "Kurskod", "Total genomströmning", };
		dtmSearch.setColumnIdentifiers(studying);

		ArrayList<Studied> updatestudied = Controller.showAvgflow();
		for (int i = 0; i < updatestudied.size(); i++) {

			String cCodes = updatestudied.get(i).getcCode().toUpperCase();
			String total = updatestudied.get(i).getTotal();

			Object[] searchData = { cCodes, total };

			dtmSearch.addRow(searchData);

		}
		searchTable.setModel(dtmSearch);
	}

	private void updateSearchTableToFitStudent(String sPnr, String cCode) {

		DefaultTableModel dtmSearch = new DefaultTableModel();
		String[] studied = { "Personnummer", "Kurskod", "Termin", "Betyg" };
		dtmSearch.setColumnIdentifiers(studied);

		Studied updatestudied = Controller.getStudentStudied(sPnr, cCode);

		String sPnrOne = updatestudied.getsPnr().toUpperCase();
		String cCodeTwo = updatestudied.getcCode().toUpperCase();
		String semester = updatestudied.getSemester().toUpperCase();
		String grade = updatestudied.getGrade().toUpperCase();

		Object[] searchData = { sPnrOne, cCodeTwo, semester, grade };

		dtmSearch.addRow(searchData);

		searchTable.setModel(dtmSearch);

	}

	private void updateSearchTableToStudyingCcode(String cCode) {
		DefaultTableModel dtmSearch = new DefaultTableModel();
		String[] studied = { "Personnummer", "Kurskod", "Termin" };
		dtmSearch.setColumnIdentifiers(studied);

		ArrayList<Studying> updatestudied = Controller
				.showStudyingCourses(cCode);

		for (int i = 0; i < updatestudied.size(); i++) {
			String cCodes = updatestudied.get(i).getcCode().toUpperCase();
			String semester = updatestudied.get(i).getSemester().toUpperCase();
			String sPnr = updatestudied.get(i).getsPnr().toUpperCase();

			Object[] searchData = { cCodes, semester, sPnr };

			dtmSearch.addRow(searchData);

		}
		searchTable.setModel(dtmSearch);

	}
}
