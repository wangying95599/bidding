function setModalData(modal, mapper, data) {
    Object.keys(mapper).forEach(function (key) {
        if (data) {
            const modelFieldName = mapper[key];
            modal.find('#' + key).val(data[modelFieldName]);
        } else {
            modal.find('#' + key).val(null);
        }
    });
}