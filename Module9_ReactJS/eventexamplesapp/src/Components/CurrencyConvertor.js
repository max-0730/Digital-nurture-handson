import React, { Component } from "react";

class CurrencyConvertor extends Component {

    constructor(props){

        super(props);

        this.state={

            rupees:"",
            euro:""

        };

    }

    handleChange=(event)=>{

        this.setState({

            rupees:event.target.value

        });

    }

    handleSubmit=()=>{

        const euro=this.state.rupees/90;

        this.setState({

            euro:euro.toFixed(2)

        });

    }

    render(){

        return(

            <div style={{textAlign:"center",marginTop:"30px"}}>

                <h2>Currency Convertor</h2>

                <input

                    type="number"

                    placeholder="Enter Rupees"

                    onChange={this.handleChange}

                />

                <br/><br/>

                <button onClick={this.handleSubmit}>

                    Convert

                </button>

                <h3>Euro : € {this.state.euro}</h3>

            </div>

        );

    }

}

export default CurrencyConvertor;