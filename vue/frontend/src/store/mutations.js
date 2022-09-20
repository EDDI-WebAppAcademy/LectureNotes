import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_MY_INVENTORY,
    REQUEST_CHARACTER_STATUS_FROM_SPRING,
    REQUEST_CHARACTER_STATUS_UPDATE_FROM_SPRING,
    REQUEST_BOARD_LIST_FROM_SPRING,
    REQUEST_BOARD_FROM_SPRING,
} from './mutation-types'

export default {
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {
        state.springFromVueTestValue = passingData
    },
    [REQUEST_RANDOM_SHOP_ITEM] (state, passingData) {
        state.randomShopItem = passingData
    },
    [REQUEST_MY_INVENTORY] (state, passingData) {
        state.myInventory = passingData
    },
    [REQUEST_CHARACTER_STATUS_FROM_SPRING] (state, passingData) {
        state.characterStatus = passingData
    },
    [REQUEST_CHARACTER_STATUS_UPDATE_FROM_SPRING] (state, passingData) {
        state.characterStatusUpdateFlag = passingData
    },
    [REQUEST_BOARD_LIST_FROM_SPRING] (state, passingData) {
        state.boards = passingData
    },
    [REQUEST_BOARD_FROM_SPRING] (state, passingData) {
        state.board = passingData
    },
}