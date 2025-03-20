
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderServiceOrderManager from "./components/listers/OrderServiceOrderCards"
import OrderServiceOrderDetail from "./components/listers/OrderServiceOrderDetail"

import SupportServiceDeliveryadManager from "./components/listers/SupportServiceDeliveryadCards"
import SupportServiceDeliveryadDetail from "./components/listers/SupportServiceDeliveryadDetail"
import SupportServiceInventoryManager from "./components/listers/SupportServiceInventoryCards"
import SupportServiceInventoryDetail from "./components/listers/SupportServiceInventoryDetail"


import ViewStatusView from "./components/ViewStatusView"
import ViewStatusViewDetail from "./components/ViewStatusViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orderServices/orders',
                name: 'OrderServiceOrderManager',
                component: OrderServiceOrderManager
            },
            {
                path: '/orderServices/orders/:id',
                name: 'OrderServiceOrderDetail',
                component: OrderServiceOrderDetail
            },

            {
                path: '/supportServices/deliveryads',
                name: 'SupportServiceDeliveryadManager',
                component: SupportServiceDeliveryadManager
            },
            {
                path: '/supportServices/deliveryads/:id',
                name: 'SupportServiceDeliveryadDetail',
                component: SupportServiceDeliveryadDetail
            },
            {
                path: '/supportServices/inventories',
                name: 'SupportServiceInventoryManager',
                component: SupportServiceInventoryManager
            },
            {
                path: '/supportServices/inventories/:id',
                name: 'SupportServiceInventoryDetail',
                component: SupportServiceInventoryDetail
            },


            {
                path: '/dashboardservices/viewStatuses',
                name: 'ViewStatusView',
                component: ViewStatusView
            },
            {
                path: '/dashboardservices/viewStatuses/:id',
                name: 'ViewStatusViewDetail',
                component: ViewStatusViewDetail
            },


    ]
})
