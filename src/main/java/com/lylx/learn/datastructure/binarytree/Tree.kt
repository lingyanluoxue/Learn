package com.lylx.learn.datastructure.binarytree

class Tree {
    var root: Node? = null

    /**
     * 查找最小值
     *
     * 1. 先走到根的左子节点处
     * 2. 接着走到那个子节点的左子节点，如此类推，直到找到一个没有左子节点的节点，此节点即为最小值的节点。
     */
    fun minimum(): Node? {
        var current = root
        var last = root
        while (current != null) {
            last = current
            current = last.leftChild
        }
        return last
    }

    /**
     * 查找最大值
     *
     * 1. 先走到根的右子节点处
     * 2. 接着走到那个子节点的右子节点，如此类推，直到找到一个没有右子节点的节点，此节点即为最小值的节点。
     */
    fun maximum(): Node? {
        var current = root
        var last = root
        while (current != null) {
            last = current
            current = last.rightChild
        }
        return last
    }

    /**
     * 中序遍历树
     *
     * 初始时用根作为参数调用此方法
     * a. 调用自身来遍历节点的左子树
     * b. 访问这个节点
     * c. 调用自身来遍历节点的右子树
     * 直至所有的节点都被访问为止，此时 localRoot 为 null 返回
     */
    fun inOrder(localRoot: Node?) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild)
            print("${localRoot.id} ")
            inOrder(localRoot.rightChild)
        }
    }

    /**
     * 前序遍历
     *
     * 初始时用根作为参数调用此方法
     * a. 访问这个节点
     * b. 调用自身来遍历节点的左子树
     * c. 调用自身来遍历节点的右子树
     * 直至所有的节点都被访问为止，此时 localRoot 为 null 返回
     */
    fun preOrder(localRoot: Node?) {
        if (localRoot != null) {
            print("${localRoot.id} ")
            preOrder(localRoot.leftChild)
            preOrder(localRoot.rightChild)
        }
    }

    /**
     * 后续遍历
     *
     * 初始时用根作为参数调用此方法
     * a. 调用自身来遍历节点的左子树
     * b. 调用自身来遍历节点的右子树
     * c. 访问这个节点
     * 直至所有的节点都被访问为止，此时 localRoot 为 null 返回
     */
    fun postOrder(localRoot: Node?) {
        if (localRoot!=null){
            postOrder(localRoot.leftChild)
            postOrder(localRoot.rightChild)
            print("${localRoot.id} ")
        }
    }

    /**
     * 插入节点
     *
     * parent 是 current 父节点，用来存储最后一个不是 null 的节点
     * 插入节点： parent（最后一个非 null 节点）对应的子指针指向新节点
     *
     * 1. root 为空，将根置为当前插入节点
     * 2. root 不为空，循环查找插入节点位置，对比当前插入节点和 parent 节点的关键字值
     *     a. 插入节点关键字值小于 parent 节点关键字值，将 current 节点设为 parent 左子节点，
     *        parent 左子节点不存在，将插入节点接到 parent 左子节点处
     *     b. 插入节点关键字值大于等于 parent 节点关键字值，将 current 节点设为 parent 右子节点，
     *        parent 右子节点不存在，将插入节点接到 parent 右子节点处
     *
     */
    fun insert(id: Int, value: Double) {
        val node = Node(id, value)
        // root 是否为空，为空则将根置为当前插入节点，不为空循环查找插入节点位置
        if (root == null) {
            root = node
        } else {
            // 使用 parent 存储 current 的父节点
            var current = root
            var parent: Node
            while (true) {
                parent = current!!
                // 对比当前插入节点 id 和 parent 节点 id，
                // 插入节点 id < parent 节点 id ,则将 current 节点设为 parent 左子节点，parent 左子节点不存在，将插入节点接到 parent 的左子节点处
                // 插入节点 id >= parent 节点 id，则将 current 节点设为 parent 右子节点，parent 右子节点不存在，将插入节点接到 parent 的右子节点处
                if (id < parent.id) {
                    current = parent.leftChild
                    if (current == null) {
                        parent.leftChild = node
                        return
                    }
                } else {
                    current = parent.rightChild
                    if (current == null) {
                        parent.rightChild = node
                        return
                    }
                }
            }
        }
    }

    /**
     * 查找节点
     *
     * 1. 从根开始查找，使用 current 表示正在查看的节点
     * 2. 循环对比寻找节点和当前节点的关键字值是否相等，
     *    寻找节点和当前节点关键字值不相等，则对比寻找节点和当前节点关键字,
     *    直到 id 相等停止循环，找到并返回该节点 current
     *        a. 小于当前节点关键字值，将 current 设为该节点的左子节点
     *        b. 大于等于当前节点关键字值，将 current 设为该节点的右子节点
     *        c. current == null ,表明查找节点不存在，返回 null
     */
    fun find(id: Int): Node? {
        // current 正在查看的节点，从根开始查找
        var current = root
        // 对比寻找节点 id 和 当前节点 id 值是否相等，不相等则循环对比关键字值大小，直到 id 值相等停止循环，找到该节点，返回 current 节点
        while (current?.id != id) {
            // 寻找的节点 id 值与当前节点的 id 值进行对比，
            // 寻找节点 id < 当前节点 id，说明要找的节点在该节点的左子节点 or 左子节点的子孙节点之一，将 current 设为该节点的左子节点
            // 寻找节点 id >= 当前节点 id，将 current 设为该节点的右子节点
            if (current != null) {
                current = if (id < current.id) {
                    current.leftChild
                } else {
                    current.rightChild
                }
            }
            // current == null，在查找序列中找不到下一个节点；到达序列的末端而没有找到要找的节点，表明不存在，返回 null
            if (current == null) {
                return null
            }
        }
        return current
    }

    /**
     * 删除没有子节点的节点（叶节点）
     *
     * parent 是 current 的父节点，用于存储要删除节点的父节点，便于修改它的子字段的值
     * current 用于存储当前查看的节点，便于查找要删除的节点
     *
     * 1. 查找节点
     *    1>. 从根开始查找要删除的节点，使用 current 表示正在查看的节点
     *    2>. 要查找的节点和当前节点关键字值不相等，则对比寻找节点和当前节点关键字,
     *        直到 id 相等停止循环，找到要删除的节点
     *        a. 小于当前节点关键字值，将 current 设为该节点的左子节点
     *        b. 大于等于当前节点关键字值，将 current 设为该节点的右子节点
     *        c. current == null ,表明要删除的节点不存在，返回 false
     *  2. 删除节点：找到要删除的节点，检查它是否没有子节点，
     *     1>. 若没有子节点，即删除的节点为叶节点
     *         要删除节点是根，把根置为 null，清空整颗树；
     *         要删除节点是左子节点，把父节点的 leftChild 置为 null，断开父节点和删除节点的链接
     *         要删除节点为右子节点，把父节点的 rightChild 置为 null，断开父节点和删除节点的链接
     *     2>. 删除有一个子节点的节点
     *         a. 删除有一个左子节点无右子节点的节点，用左子树替换
     *         b. 删除有一个右子节点无左子节点的节点，用右子树替换
     *     3> 删除有两个子节点的节点
     *        a. 获取后继节点：
     *           后继结点为要删除节点的右子节点的左子孙节点：后继结点父节点的左子节点指向置为后继结点的右子节点；后继结点的右子节点指向置为要删除节点的右子节点
     *           后继结点为要删除节点的右子节点
     *        b. 要删除节点为根，把根置为要删除节点的后继节点即可
     *           要删除节点为左子节点，把父节点的 leftChild 置为后继结点
     *           要删除节点为右子节点，把父节点的 rightChild 置为后继结点
     *        c. 后继节点的左子节点指向置为要删除节点的左子节点
     */
    fun delete(id: Int): Boolean {
        var current = root
        var parent = root
        var isLeftNode = false
        while (current?.id != id) {
            if (current != null) {
                parent = current
                current = if (id < current.id) {
                    isLeftNode = true
                    current.leftChild
                } else {
                    isLeftNode = false
                    current.rightChild
                }
            }
            if (current == null) {
                return false
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            // 当前删除节点没有子节点，即当前删除节点为叶节点
            when {
                current == root -> root = null
                isLeftNode -> parent?.leftChild = null
                !isLeftNode -> parent?.rightChild = null
            }
        } else if (current.rightChild == null) {
            // 删除有一个子节点的节点：删除有一个左子节点无右子节点的节点，用左子树替换
            when {
                current == root -> root = current.leftChild
                isLeftNode -> parent?.leftChild = current.leftChild
                !isLeftNode -> parent?.rightChild = current.leftChild
            }
        } else if (current.leftChild == null) {
            // 删除有一个子节点的节点：删除有一个右子节点无左子节点的节点，用右子树替换
            when {
                current == root -> root = current.rightChild
                isLeftNode -> parent?.leftChild = current.rightChild
                !isLeftNode -> parent?.rightChild = current.rightChild

            }
        } else {
            val successor = getSuccessor(current)
            when {
                current == root -> root = successor
                isLeftNode -> parent?.leftChild = successor
                !isLeftNode -> parent?.rightChild = successor
            }
            successor.leftChild = current.leftChild
        }
        return true
    }

    /**
     * 获取后继节点
     *
     * current 目前查看的节点
     * successor 后继结点
     * successorParent 后继结点的父节点
     *
     * 1. 获取删除节点的右子节点
     * 2. 循环遍历，顺着要删除节点的右子节点的所有左子节点一直往下查找后继结点，直至 current 为空
     *    a. 要删除节点右子节点的左子孙节点为后继节点：要删除节点的右子节点有左子节点，则顺着所有左子节点找下去，此路径上最后一个左子节点即为后继结点
     *    b. 要删除节点的右子节点即为后继结点：要删除节点的右子节点无左子节点，则要删除节点的右子节点即为后继结点
     * 3. 后继节点不是要删除节点的右子节点
     *    a. 后继结点父节点的左子节点指向后继结点的右子节点
     *    b. 后继结点的右子节点指向要删除节点的右子节点
     */
    private fun getSuccessor(delNode: Node): Node {
        var successorParent = delNode
        var successor = delNode
        var current = delNode.rightChild
        // 循环遍历，顺着要删除节点的右子节点的所有左子节点一直往下查找后继结点，直至 current 为空
        while (current != null) {
            successorParent = successor
            successor = current
            current = current.leftChild
        }
        // 后继节点不是要删除节点的右子节点：
        // 后继结点父节点的左子节点指向后继结点的右子节点；
        // 后继结点的右子节点指向要删除节点的右子节点
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild
            successor.rightChild = delNode.rightChild
        }
        return successor
    }
}