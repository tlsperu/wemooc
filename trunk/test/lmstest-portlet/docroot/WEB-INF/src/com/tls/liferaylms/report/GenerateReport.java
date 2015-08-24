package com.tls.liferaylms.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.tls.liferaylms.test.util.Context;

public class GenerateReport {

	String ruta = "Test-Report.txt";
	File archivo; //new File(ruta);
	BufferedWriter bw;
	
	public File generateFile() throws IOException{
		
		archivo = File.createTempFile("Test-Report", ".txt");
		
		bw = new BufferedWriter(new FileWriter(archivo));
            
		bw.write("PRUEBAS REALIZADAS EN EL TEST");
//		bw.newLine();
//		bw.newLine();
		bw.write("\r\n");
		bw.write("\r\n");
            
		//LoginTest
		writeLoginTest();
        	
		//CreateUsers
		writeCreateUsersTest();
        	
		//CreateTestPage
		writeCreateTestPageTest();
        	
		//AdminCourse
		writeAdminCourseTest();

		//CheckUsers
		writeCheckUsersTest();
        	
		//CreateActivity 
		writeCreateActivityTest();
        	
//		//CheckActivity
//		writeCheckActivityTest();
//        	
//		//CheckResults
//		writeCheckResultsTest();
		
		bw.flush();
		bw.close();
		
		return archivo;
	}
	
	private void writeCreateActivityTest() throws IOException {
		
//		bw.newLine();
		bw.write("\r\n");
		bw.write("Creación de actividades:");
//		bw.newLine();
		bw.write("\r\n");
		
		if (BeanReportContext.isModule()){
			bw.write(" - Se ha creado un Módulo nuevo.");
		}
		
		if (BeanReportContext.isTestActivityDrag()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad Test de tipo 'Arrastrar'.");
		}
		
		if (BeanReportContext.isTestActivitySort()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad Test de tipo 'Ordenable'.");
		}
		if (BeanReportContext.isTestActivityFill()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad Test de tipo 'Rellena Espacio'.");
		}
		
		if (BeanReportContext.isTestActivityFree()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad Test de tipo 'Texto Libre'.");
		}
		
		if (BeanReportContext.isTestActivityMulti()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad Test de tipo 'Respuesta Múltiple'.");
		}
		
		if (BeanReportContext.isTestActivityOption()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad Test de tipo 'Opciones'.");
		}
		
		if (BeanReportContext.isExtResourceActivity()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad de Recurso Externo.");
		}
		
		if (BeanReportContext.isP2PActivity()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad P2P.");
		}
		
		if (BeanReportContext.isPollActivity()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad de Encuesta.");
		}
		
		if (BeanReportContext.isClassWorkActivity()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad de Tarea Presencial.");
		}
		
		if (BeanReportContext.isDevelopActivity()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad de Desarrollo.");
		}
		
		if (BeanReportContext.isMultimediaResource()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad de Recurso Multimedia.");
		}
		
		if (BeanReportContext.isEvalueActivity()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad de Evaluación.");
		}
		
		if (BeanReportContext.isSCORMActivity()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado una Actividad SCORM.");
		}
//		bw.newLine();
		bw.write("\r\n");
		
	}

	private void writeCheckUsersTest() throws IOException {
		
//		bw.newLine();
		bw.write("\r\n");
		bw.write("Asignar miembros al curso:");
//		bw.newLine();
		bw.write("\r\n");
		
		if (BeanReportContext.isStudentAsign()){
			bw.write(" - Se ha asignado al curso el miembro 'Student' como Estudiante.");
		}
		
		if (BeanReportContext.isStudent2Asign()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha asignado al curso el miembro 'Student2' como Estudiante.");
		}
		
		if (BeanReportContext.isTeacherAsign()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha asignado al curso el miembro 'Teacher' como Profesor.");
		}
		if (BeanReportContext.isSubTeacherAsign()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha asignado al curso el miembro 'Teacher' como Profesor sustituto.");
		}
//		bw.newLine();
		bw.write("\r\n");
	}

	private void writeAdminCourseTest() throws IOException {
		
//		bw.newLine();
		bw.write("\r\n");
		bw.write("Creación de un Curso:");
//		bw.newLine();
		bw.write("\r\n");
		
		if (BeanReportContext.isCreateCourse()) 
			bw.write(" - Se ha creado un nuevo curso con la URL: '" + Context.getCoursePage() + "'.");
		
		if (BeanReportContext.isCourseChecked()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - El curso se ha chequeado y está creado correctamente.");
		}
		
//		bw.newLine();
		bw.write("\r\n");
	}

	private void writeCreateTestPageTest() throws IOException {
		
//		bw.newLine();
		bw.write("\r\n");
		bw.write("Creación de Página 'Test':");
//		bw.newLine();
		bw.write("\r\n");
		
		if (BeanReportContext.isCreateTestPage()) 
			bw.write(" - Se ha creado una nueva página con la URL: '" + Context.getTestPage() + "'.");
		
//		bw.newLine();
		bw.write("\r\n");
	}

	private void writeCreateUsersTest() throws IOException{
		
//		bw.newLine();
		bw.write("\r\n");
		bw.write("Creación de Usuarios:");
//		bw.newLine();
		bw.write("\r\n");
		
		if (BeanReportContext.isCreateStudent()){
			bw.write(" - Se ha creado un nuevo usuario 'Student'.");
		}
		if (BeanReportContext.isCreateStudent2()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado un nuevo usuario 'Student2'.");
		}
		if (BeanReportContext.isCreateTeacher()){
//			bw.newLine();
			bw.write("\r\n");
			bw.write(" - Se ha creado un nuevo usuario 'Teacher'.");
		}
		
//		bw.newLine();
		bw.write("\r\n");
	}

	public void writeLoginTest() throws IOException{
		
//		bw.newLine();
		bw.write("\r\n");
		bw.write("Test Login:");
//		bw.newLine();
		bw.write("\r\n");
		
		if (BeanReportContext.isHasLogin()) 
			bw.write(" - Se ha hecho Login con el usuario 'Test'");
		else
			bw.write(" - No se ha podido hacer Login con el usuario 'Test'.");
		
//		bw.newLine();
		bw.write("\r\n");
	}
}
