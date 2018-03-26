'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./services/client');
// end::vars[]

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {employees: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/users'}).done(response => {
	
			this.setState({employees: response.entity.data});
		});
	}

	render() {
		return (
			
			<EmployeeList employees={this.state.employees}/>
		)
	}
}
// end::app[]

// tag::employee-list[]
class EmployeeList extends React.Component{
	constructor(props) {
		super(props);
		
	}

	render() {
	
		var demployees = this.props.employees.map(employee => <Employee key={employee.FirstName} employee={employee}/>);

		return (
			<table>
				<tbody>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Description</th>
					</tr>
					{demployees}
				</tbody>
			</table>
		)
	}
}
// end::employee-list[]

// tag::employee[]
class Employee extends React.Component{


	render() {

		return (
			<tr>
				
				<td>{this.props.employee.FirstName}</td>
				<td>{this.props.employee.LastName}</td>
				<td>{this.props.employee.Description}</td>
			</tr>
		)
	}
}
// end::employee[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]

