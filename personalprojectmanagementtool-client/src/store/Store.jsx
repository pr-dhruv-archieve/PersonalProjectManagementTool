import thunk from "redux-thunk";
import {applyMiddleware, compose, createStore} from "redux";
import rootReducer from "./../reducers"
// Setup Initial State as blank
const INITIAL_STATE = {};

// Steup Middleware
const middleware = [thunk];

// Creating Store
let STORE;

if(window.navigator.userAgent.includes("Chrome")) {
    STORE = createStore(
        rootReducer, INITIAL_STATE, compose(applyMiddleware(...middleware),window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__())
    );
} else {
    STORE =  createStore(
        rootReducer, INITIAL_STATE, compose(applyMiddleware(...middleware))
    );
}

export default STORE;