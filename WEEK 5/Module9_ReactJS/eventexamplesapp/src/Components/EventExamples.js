import React, { Component } from "react";

class EventExamples extends Component {

    constructor(props) {
        super(props);

        this.state = {
            count: 0
        };
    }

    increment = () => {
        this.setState({
            count: this.state.count + 1
        });
    }

    decrement = () => {
        this.setState({
            count: this.state.count - 1
        });
    }

    sayHello = () => {
        alert("Hello! Have a nice day.");
    }

    increase = () => {
        this.increment();
        this.sayHello();
    }

    sayWelcome = (msg) => {
        alert(msg);
    }

    onPress = () => {
        alert("I was clicked");
    }

    render() {

        return (

            <div style={{textAlign:"center"}}>

                <h1>Counter : {this.state.count}</h1>

                <button onClick={this.increase}>
                    Increment
                </button>

                <button onClick={this.decrement}>
                    Decrement
                </button>

                <br/><br/>

                <button onClick={()=>this.sayWelcome("Welcome")}>
                    Say Welcome
                </button>

                <br/><br/>

                <button onClick={this.onPress}>
                    OnPress
                </button>

            </div>

        );

    }

}

export default EventExamples;