package com.jlt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jlt.controller.Employee;
import com.jlt.factory.ConnectionFactory;

public class EmployeeDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private int rowCount;
	private String sql;
	private ResultSet resultSet;

	public boolean addNewEmployee(Employee employee) {
		try {

			sql = "insert into employee_master(first_name,last_name,salary,email) values(?,?,?,?)";
			connection = new ConnectionFactory().getDBConnection();

			if (connection != null) {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, employee.getFirstName());
				preparedStatement.setString(2, employee.getLastName());
				preparedStatement.setDouble(3, employee.getSalary());
				preparedStatement.setString(4, employee.getEmail());

				rowCount = preparedStatement.executeUpdate();
				connection.close();
				if (rowCount > 0)
					return true;

			}

		} catch (Exception e) {
			System.out.println("Exception=" + e.getMessage());

		}
		return false;

	}

	public List<Employee> getAllEmployees() {
		try {
			sql = "select * from employee_master";
			connection = new ConnectionFactory().getDBConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			List<Employee> employeeList = new ArrayList<Employee>();

			while (resultSet.next()) {

				Employee employee = new Employee();

				employee.setEmployeeId(resultSet.getInt("employee_id"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setSalary(resultSet.getDouble("salary"));
				employee.setEmail(resultSet.getString("email"));

				System.out.println(employee);
				employeeList.add(employee);

			}
			connection.close();
			return employeeList;
		} catch (Exception e) {

			System.out.println("Exception =" + e.getMessage());
		}

		return null;

	}

	public boolean deleteEmployee(int employeeId) {
		try {
			sql = "delete from employee_master where employee_id=?";
			connection = new ConnectionFactory().getDBConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeId);

			rowCount = preparedStatement.executeUpdate();
			connection.close();
			if (rowCount > 0)
				return true;

		} catch (Exception e) {
			System.out.println("Exception=" + e.getMessage());
		}
		return false;

	}

}
