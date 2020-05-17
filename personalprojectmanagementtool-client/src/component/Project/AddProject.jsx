import React, {Component} from 'react'

export default class AddProject extends Component {
    constructor(props) {
        super(props);
        this.state= {
            projectName: "",
            projectIdentifier: "",
            description: "",
            startDate: "",
            endDate: ""
        };
        this.submitForm = this.submitForm.bind(this);
    }

    onChangeForField = (event) => {
        // event.preventDefault();
        this.setState({ [event.target.name] : [event.target.value] });
    };

    submitForm = (event) => {
        event.preventDefault();
        const newProject = {
            projectName: this.state.projectName,
            projectIdentifier: this.state.projectIdentifier,
            description: this.state.description,
            startDate: this.state.startDate,
            endDate: this.state.endDate
        };  // Or simply newProject = this.state this will also work

        console.log(newProject);
    };

    render() {
        return (
            <div>
                <div className="project">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-8 m-auto">
                                <h5 className="display-4 text-center">Create Project form</h5>
                                <hr/>
                                <form onSubmit={this.submitForm}>
                                    <div className="form-group">
                                        <input type="text" className="form-control form-control-lg "
                                               placeholder="Project Name" name="projectName" value={this.state.projectName} onChange={this.onChangeForField}/>
                                    </div>
                                    <div className="form-group">
                                        <input type="text" className="form-control form-control-lg"
                                               placeholder="Unique Project ID" name="projectIdentifier" value={this.state.projectIdentifier}  onChange={this.onChangeForField}/>
                                    </div>
                                    <div className="form-group">
                                        <textarea className="form-control form-control-lg" placeholder="Project Description" name="description" value={this.state.description} onChange={this.onChangeForField}/>
                                    </div>
                                    <h6>Start Date</h6>
                                    <div className="form-group">
                                        <input type="date" className="form-control form-control-lg" name="startDate" value={this.state.startDate} onChange={this.onChangeForField}/>
                                    </div>
                                    <h6>Estimated End Date</h6>
                                    <div className="form-group">
                                        <input type="date" className="form-control form-control-lg" name="endDate" value={this.state.endDate} onChange={this.onChangeForField}/>
                                    </div>

                                    <input type="submit" className="btn btn-primary btn-block mt-4"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
