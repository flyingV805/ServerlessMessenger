package kz.flyingv.serverlessmessenger.ui.screen.companions

import kz.flyingv.serverlessmessenger.data.model.Companion

sealed class CompanionsAction {

    class StartChat(val companion: Companion): CompanionsAction()

}