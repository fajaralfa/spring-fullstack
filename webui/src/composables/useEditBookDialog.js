import { ref } from "vue"

export function useEditBookDialog() {
    const editBookDialogVisible = ref(false)
    const editBookData = ref({})

    function editBookDialog(book) {
        editBookData.value.link = book._links.self.href
        editBookData.value.data = {
            title: book.title,
            author: book.author,
            description: book.description,
        }
        editBookDialogVisible.value = true
    }

    return { editBookData, editBookDialog, editBookDialogVisible }
}