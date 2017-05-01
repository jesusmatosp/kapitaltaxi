package com.kapital.sitramas.procesos;

import java.util.List;
import org.springframework.batch.item.ItemWriter;

import com.kapital.sitramas.servicios.dto.Employee;

public class EmployeeImporterWriter implements ItemWriter<Employee> {

	public void write(List<? extends Employee> arg0) throws Exception {
		// TODO Auto-generated method stub
		for (Employee employee : arg0) {
            System.out.println(employee.toString());
        }
	}
	
}
