import {
    REQUEST_DATA_FROM_SPRING,
} from './mutation-types'

// npm install axios --save-dev
import axios from 'axios'

export default {
    requestDataFromSpring ({ commit }) {
        console.log("I'm from action - requestDataFromSpring()")

        return axios.get('http://localhost:7777/30th/vue2spring/test')
            .then((res) => {
                commit(REQUEST_DATA_FROM_SPRING, res.data)
            })
    }
}