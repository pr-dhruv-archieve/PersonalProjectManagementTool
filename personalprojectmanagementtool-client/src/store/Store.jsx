import {createStore, applyMiddleware, compose} from "redux";
import thunk from "redux-thunk";
import rootReducer from "./../reducers"

// Steup initial State
const initialState = {};

// setup middleware
const middleware = [thunk];

// Creating Store
let STORE;

if(window.navigator.userAgent.includes("Chrome")) {
    STORE = createStore(
        rootReducer, initialState, compose(...applyMiddleware(), window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__())
    );
} else {
    STORE = createStore(
        rootReducer, initialState, compose(...applyMiddleware())
    );
}

export default STORE;