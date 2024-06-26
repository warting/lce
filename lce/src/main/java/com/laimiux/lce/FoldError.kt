package com.laimiux.lce

inline fun <L, C, E, T> LCE<L, C, E>.foldError(
    onError: (E) -> T,
    onOther: (LC<L, C>) -> T
): T {
    return foldTypes(
        onError = { onError(it.value) },
        onOther = onOther
    )
}

inline fun <C, E, T> UCE<C, E>.foldError(
    onError: (E) -> T,
    onOther: (UC<C>) -> T
): T {
    return foldTypes(
        onError = { onError(it.value) },
        onOther = onOther
    )
}

inline fun <C, T> UCT<C>.foldError(
    onError: (Throwable) -> T,
    onOther: (UC<C>) -> T
): T {
    return foldTypes(
        onError = { onError(it.value) },
        onOther = onOther
    )
}
