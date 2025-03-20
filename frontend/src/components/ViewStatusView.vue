<template>

    <v-data-table
        :headers="headers"
        :items="viewStatus"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ViewStatusView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "customerId", value: "customerId" },
                { text: "productId", value: "productId" },
                { text: "qty", value: "qty" },
                { text: "address", value: "address" },
                { text: "orderStatus", value: "orderStatus" },
                { text: "deliveryStatus", value: "deliveryStatus" },
                { text: "price", value: "price" },
            ],
            viewStatus : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/viewStatuses'))

            temp.data._embedded.viewStatuses.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.viewStatus = temp.data._embedded.viewStatuses;
        },
        methods: {
        }
    }
</script>

