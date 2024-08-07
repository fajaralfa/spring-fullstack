<script setup>
import Dialog from 'primevue/dialog';
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import { useAxios } from '@/composables/useAxios';
import { computed, watch } from 'vue';

const old = defineModel()

const visible = defineModel('visible')

</script>

<template>
    <Dialog header="Edit Book" v-model:visible="visible">
        <pre>{{ input }}</pre>
        <div class="space-y-3 *:block mb-5">
            <InputText v-model="input.title" name="title" placeholder="Title" />
            <InputText v-model="input.author" name="author" placeholder="Author" />
            <InputText v-model="input.description" name="description" placeholder="Description" />
        </div>
        <Button @click="$emit('click')">Update</Button>
    </Dialog>
</template>